package com.taksuinterview.kaisinema.presentation.moviedetail

import com.taksuinterview.kaisinema.common.util.rx.RxScheduler
import com.taksuinterview.kaisinema.common.util.state.HttpState
import com.taksuinterview.kaisinema.domain.repository.UserSession
import com.taksuinterview.kaisinema.domain.usecase.movie.GetDetailMovie
import com.taksuinterview.kaisinema.presentation.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class MovieDetailPresenter<V : MovieDetail.View>
@Inject internal constructor(
    session: UserSession,
    scheduler: RxScheduler,
    compositeDisposable: CompositeDisposable,
    httpEvent: PublishSubject<Pair<HttpState, String>>,
    private val getDetailMovie: GetDetailMovie
) : BasePresenter<V>(session, scheduler, compositeDisposable, httpEvent),
    MovieDetail.Presenter<V> {
    override fun getMovieDetail(movieId: Long) {
        enqueue(getDetailMovie.execute(movieId)
            .compose(scheduler.singleIoUi())
            .doOnSubscribe { view.showMainProgressBar(true) }
            .doAfterTerminate { view.showMainProgressBar(false) }
            .subscribe({
                if (it.isError) {
                    view.showError(it.message)
                } else {
                    view.showDetail(it.data!!)
                }
            }, { view.showError(it.localizedMessage) })
        )
    }
}