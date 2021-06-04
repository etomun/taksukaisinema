package com.taksuinterview.kaisinema.data.remote.source

import com.taksuinterview.kaisinema.data.remote.api.GenreApi
import com.taksuinterview.kaisinema.data.remote.api.MovieApi
import com.taksuinterview.kaisinema.data.remote.mapper.GenreListResponseMapper
import com.taksuinterview.kaisinema.data.remote.mapper.MovieDetailResponseMapper
import com.taksuinterview.kaisinema.data.remote.mapper.MovieListResponseMapper
import com.taksuinterview.kaisinema.domain.repository.MovieRepository.DataSource
import com.taksuinterview.kaisinema.domain.result.BaseResult
import com.taksuinterview.kaisinema.domain.result.Genre
import com.taksuinterview.kaisinema.domain.result.Movie
import com.taksuinterview.kaisinema.domain.result.MovieSum
import io.reactivex.Single
import javax.inject.Inject

class RemoteMovieSource @Inject internal constructor(
    private val movieApi: MovieApi,
    private val genreApi: GenreApi,
    private val movieDetailResponseMapper: MovieDetailResponseMapper,
    private val movieListResponseMapper: MovieListResponseMapper,
    private val genreListResponseMapper: GenreListResponseMapper
) : DataSource {
    override fun persistUpcomingMovies(movies: List<MovieSum>): Single<List<Long>> {
        return Single.error(UnsupportedOperationException())
    }

    override fun persistPopularMovies(movies: List<MovieSum>): Single<List<Long>> {
        return Single.error(UnsupportedOperationException())
    }

    override fun persistMovie(movie: Movie): Single<Long> {
        return Single.error(UnsupportedOperationException())
    }

    override fun persistGenres(genres: List<Genre>): Single<List<Long>> {
        return Single.error(UnsupportedOperationException())
    }

    override fun getPopularMovies(page: Int): Single<BaseResult<List<MovieSum>>> {
        return movieApi.getPopularMovies().map { movieListResponseMapper.toData(it) }
    }

    override fun getUpcomingMovies(page: Int): Single<BaseResult<List<MovieSum>>> {
        return movieApi.getUpcomingMovies().map { movieListResponseMapper.toData(it) }
    }

    override fun getDetailMovie(movieId: Long): Single<BaseResult<Movie>> {
        return movieApi.getDetailMovie(movieId).map { movieDetailResponseMapper.toData(it) }
    }

    override fun getMovieGenres(): Single<BaseResult<List<Genre>>> {
        return genreApi.getMovieGenres().map { genreListResponseMapper.toData(it) }
    }

}