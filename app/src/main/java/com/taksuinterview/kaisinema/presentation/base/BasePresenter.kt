package com.taksuinterview.kaisinema.presentation.base

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.taksuinterview.kaisinema.common.util.rx.RxScheduler
import com.taksuinterview.kaisinema.common.util.state.HttpState
import com.taksuinterview.kaisinema.domain.repository.UserSession
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject


abstract class BasePresenter<V : Presentation.View> internal constructor(
    protected val session: UserSession,
    protected val scheduler: RxScheduler,
    private val compositeDisposable: CompositeDisposable,
    private val httpEvent: PublishSubject<Pair<HttpState, String>>
) : Presentation.Presenter<V>, LifecycleObserver {

    protected lateinit var view: V
    private var viewLifecycle: Lifecycle? = null
    override fun enqueue(disposable: Disposable) {
        this.compositeDisposable.add(disposable)
    }

    override fun attachView(view: V, lifecycle: Lifecycle) {
        this.view = view
        viewLifecycle = lifecycle
        viewLifecycle!!.addObserver(this)
        subscribeHttpEvent()
        view.onPresenterAttached()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    override fun detachView() {
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
        viewLifecycle!!.removeObserver(this)
        viewLifecycle = null
    }

    override fun isLogin(): Boolean = session.isLogin()

    override fun logout() {
        enqueue(
            session.doLogout()
                .compose(scheduler.observableComputationUi())
                .subscribe({ view.onLoggedOut(it) }, { view.showError(it.localizedMessage) })
        )
    }

    private fun subscribeHttpEvent() {
        enqueue(httpEvent.compose(scheduler.observableIoUi())
            .subscribe(
                {
                    if (it != null) {
                        if (it.first == HttpState.UNAUTHORIZED) {
                            shouldLogout()
                        }
                    }
                },
                { view.showError(it.localizedMessage) }
            )
        )
    }

    private fun shouldLogout() {
        enqueue(session.doLogout().compose(scheduler.observableIoUi())
            .subscribe { view.onLoggedOut(it) })
    }
}
