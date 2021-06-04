package com.taksuinterview.kaisinema.presentation.main.popular

import com.taksuinterview.kaisinema.common.util.rx.RxScheduler
import com.taksuinterview.kaisinema.common.util.state.HttpState
import com.taksuinterview.kaisinema.domain.repository.UserSession
import com.taksuinterview.kaisinema.domain.usecase.movie.GetPopularMovies
import com.taksuinterview.kaisinema.presentation.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class PopularMoviesPresenter<V : Popular.View>
@Inject internal constructor(
    session: UserSession,
    scheduler: RxScheduler,
    compositeDisposable: CompositeDisposable,
    httpEvent: PublishSubject<Pair<HttpState, String>>,
    private val getPopularMovies: GetPopularMovies
) : BasePresenter<V>(session, scheduler, compositeDisposable, httpEvent),
    Popular.Presenter<V> {
    override fun getUpcomingMovies(page: Int) {
        enqueue(getPopularMovies.execute(page)
            .compose(scheduler.singleIoUi())
            .doOnSubscribe { view.showMainProgressBar(true) }
            .doAfterTerminate { view.showMainProgressBar(false) }
            .subscribe({
                if (it.isError) {
                    view.showError(it.message)
                } else {
                    view.showPopularMovies(it.data!!)
                }
            }, { view.showError(it.localizedMessage) })
        )
    }
}