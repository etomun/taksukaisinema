package com.taksuinterview.kaisinema.data.repository

import com.taksuinterview.kaisinema.common.di.qualifier.data.LocalData
import com.taksuinterview.kaisinema.common.di.qualifier.data.RemoteData
import com.taksuinterview.kaisinema.data.base.BaseRepository
import com.taksuinterview.kaisinema.domain.repository.MovieRepository
import com.taksuinterview.kaisinema.domain.repository.MovieRepository.DataSource
import com.taksuinterview.kaisinema.domain.result.BaseResult
import com.taksuinterview.kaisinema.domain.result.Genre
import com.taksuinterview.kaisinema.domain.result.Movie
import com.taksuinterview.kaisinema.domain.result.MovieSum
import io.reactivex.Single
import javax.inject.Inject

class MovieRepoFactory @Inject constructor(
    @LocalData localData: DataSource,
    @RemoteData remoteData: DataSource
) :
    BaseRepository<DataSource>(localData, remoteData),
    MovieRepository {
    override fun getPopularMovies(page: Int): Single<BaseResult<List<MovieSum>>> {
        checkRemoteData()
        return Single.mergeDelayError(
            remoteData!!.getPopularMovies(page).doOnSuccess {
                if (!it.data.isNullOrEmpty()) {
                    localData.persistUpcomingMovies(it.data).subscribe()
                }
            },
            localData.getPopularMovies(page).onErrorResumeNext(Single.error(::Throwable))
        ).firstOrError()
    }

    override fun getUpcomingMovies(page: Int): Single<BaseResult<List<MovieSum>>> {
        checkRemoteData()
        return Single.mergeDelayError(
            localData.getUpcomingMovies(page).onErrorResumeNext(Single.error(::Throwable)),
            remoteData!!.getUpcomingMovies(page).doOnSuccess {
                if (!it.data.isNullOrEmpty()) {
                    localData.persistUpcomingMovies(it.data).subscribe()
                }
            }
        ).firstOrError()
    }

    override fun getDetailMovie(movieId: Long): Single<BaseResult<Movie>> {
        checkRemoteData()
        return Single.mergeDelayError(
            remoteData!!.getDetailMovie(movieId).doOnSuccess {
                if (it.data != null) {
                    localData.persistMovie(it.data).subscribe()
                }
            },
            localData.getDetailMovie(movieId).onErrorResumeNext(Single.error(::Throwable))
        ).firstOrError()
    }

    override fun getMovieGenres(): Single<BaseResult<List<Genre>>> {
        return remoteData!!.getMovieGenres().doOnSuccess {
            if (!it.data.isNullOrEmpty()) {
                localData.persistGenres(it.data).subscribe()
            }
        }
    }

}