package com.taksuinterview.kaisinema.presentation.main

import com.taksuinterview.kaisinema.common.util.rx.RxScheduler
import com.taksuinterview.kaisinema.common.util.state.HttpState
import com.taksuinterview.kaisinema.domain.repository.UserSession
import com.taksuinterview.kaisinema.domain.usecase.movie.GetMovieGenres
import com.taksuinterview.kaisinema.presentation.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class MainPresenter<V : Main.View>
@Inject internal constructor(
    session: UserSession,
    scheduler: RxScheduler,
    compositeDisposable: CompositeDisposable,
    httpEvent: PublishSubject<Pair<HttpState, String>>,
    private val getMovieGenres: GetMovieGenres
) : BasePresenter<V>(session, scheduler, compositeDisposable, httpEvent),
    Main.Presenter<V> {
    override fun getMovieGenres() {
        enqueue(getMovieGenres.execute(null)
            .compose(scheduler.singleIoUi())
            .doOnSubscribe { view.showMainProgressBar(true) }
            .doAfterTerminate { view.showMainProgressBar(false) }
            .subscribe({
                if (it.isError) {
                    view.showError(it.message)
                }
            }, { view.showError(it.localizedMessage) })
        )
    }
}