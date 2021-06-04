package com.taksuinterview.kaisinema.presentation.launcher

import com.taksuinterview.kaisinema.common.util.rx.RxScheduler
import com.taksuinterview.kaisinema.common.util.state.HttpState
import com.taksuinterview.kaisinema.domain.repository.UserSession
import com.taksuinterview.kaisinema.presentation.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class LauncherPresenter<V : Launcher.View>
@Inject internal constructor(
    session: UserSession,
    scheduler: RxScheduler,
    compositeDisposable: CompositeDisposable,
    httpEvent: PublishSubject<Pair<HttpState, String>>
) : BasePresenter<V>(session, scheduler, compositeDisposable, httpEvent),
    Launcher.Presenter<V> {

    override fun checkAuthStatus() {
        view.switchAuthStatus(session.isLogin())
    }


}