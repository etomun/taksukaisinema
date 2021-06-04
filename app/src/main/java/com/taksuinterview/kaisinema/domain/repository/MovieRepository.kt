package com.taksuinterview.kaisinema.domain.repository

import com.taksuinterview.kaisinema.domain.result.BaseResult
import com.taksuinterview.kaisinema.domain.result.Genre
import com.taksuinterview.kaisinema.domain.result.Movie
import com.taksuinterview.kaisinema.domain.result.MovieSum
import io.reactivex.Single

interface MovieRepository {
    fun getPopularMovies(page: Int): Single<BaseResult<List<MovieSum>>>
    fun getUpcomingMovies(page: Int): Single<BaseResult<List<MovieSum>>>
    fun getDetailMovie(movieId: Long): Single<BaseResult<Movie>>
    fun getMovieGenres(): Single<BaseResult<List<Genre>>>

    interface DataSource :
        MovieRepository {
        fun persistUpcomingMovies(movies: List<MovieSum>): Single<List<Long>>
        fun persistPopularMovies(movies: List<MovieSum>): Single<List<Long>>
        fun persistMovie(movie: Movie): Single<Long>
        fun persistGenres(genres: List<Genre>): Single<List<Long>>
    }
}