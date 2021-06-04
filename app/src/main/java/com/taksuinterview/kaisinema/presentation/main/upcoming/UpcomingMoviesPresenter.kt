package com.taksuinterview.kaisinema.presentation.main.upcoming

import com.taksuinterview.kaisinema.common.util.rx.RxScheduler
import com.taksuinterview.kaisinema.common.util.state.HttpState
import com.taksuinterview.kaisinema.domain.repository.UserSession
import com.taksuinterview.kaisinema.domain.usecase.movie.GetUpcomingMovies
import com.taksuinterview.kaisinema.presentation.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class UpcomingMoviesPresenter<V : Upcoming.View>
@Inject internal constructor(
    session: UserSession,
    scheduler: RxScheduler,
    compositeDisposable: CompositeDisposable,
    httpEvent: PublishSubject<Pair<HttpState, String>>,
    private val getUpcomingMovies: GetUpcomingMovies
) : BasePresenter<V>(session, scheduler, compositeDisposable, httpEvent),
    Upcoming.Presenter<V> {
    override fun getUpcomingMovies(page: Int) {
        enqueue(getUpcomingMovies.execute(page)
            .compose(scheduler.singleIoUi())
            .doOnSubscribe { view.showMainProgressBar(true) }
            .doAfterTerminate { view.showMainProgressBar(false) }
            .subscribe({
                if (it.isError) {
                    view.showError(it.message)
                } else {
                    view.showUpcomingMovies(it.data!!)
                }
            }, { view.showError(it.localizedMessage) })
        )
    }
}