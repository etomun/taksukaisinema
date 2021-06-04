package com.taksuinterview.kaisinema.data.local.source

import com.taksuinterview.kaisinema.data.local.database.AppDatabase
import com.taksuinterview.kaisinema.data.local.database.genre.GenreEntity
import com.taksuinterview.kaisinema.data.local.database.moviedetail.MovieGenreCrossEntity
import com.taksuinterview.kaisinema.data.local.mapper.*
import com.taksuinterview.kaisinema.domain.repository.MovieRepository.DataSource
import com.taksuinterview.kaisinema.domain.result.BaseResult
import com.taksuinterview.kaisinema.domain.result.Genre
import com.taksuinterview.kaisinema.domain.result.Movie
import com.taksuinterview.kaisinema.domain.result.MovieSum
import io.reactivex.Single
import javax.inject.Inject

class LocalMovieSource @Inject internal constructor(
    private val db: AppDatabase,
    private val upcomingMoviesMapper: UpcomingMoviesEntityMapper,
    private val popularMoviesEntityMapper: PopularMoviesEntityMapper,
    private val movieEntityMapper: MovieEntityMapper,
    private val genreEntityMapper: GenreEntityMapper,
    private val movieDetailMapper: MovieDetailMapper,
) : DataSource {
    override fun persistUpcomingMovies(movies: List<MovieSum>): Single<List<Long>> {
        return db.upcomingMovieDao().insertReplace(upcomingMoviesMapper.fromData(movies))
    }

    override fun persistPopularMovies(movies: List<MovieSum>): Single<List<Long>> {
        return db.popularMovieDao().insertReplace(popularMoviesEntityMapper.fromData(movies))
    }

    override fun persistMovie(movie: Movie): Single<Long> {
        val movieGenres: ArrayList<MovieGenreCrossEntity> = arrayListOf()
        val genres: ArrayList<GenreEntity> = arrayListOf()
        movie.genres.map {
            movieGenres.add(MovieGenreCrossEntity(movie.id, it.id))
            genres.add(genreEntityMapper.fromData(it))
        }

        val insertGenres = db.genreDao().insertReplace(genres)
        val insertMovieGenres = db.movieGenreDao().insertReplace(movieGenres)
        val insertMovie = db.movieDao().insertReplace(movieEntityMapper.fromData(movie))

        return insertGenres.flatMap { insertMovie }.doOnSuccess { insertMovieGenres.subscribe() }
    }

    override fun persistGenres(genres: List<Genre>): Single<List<Long>> {
        val genreEntities = genres.map { genreEntityMapper.fromData(it) }
        return db.genreDao().insertReplace(genreEntities)
    }

    override fun getPopularMovies(page: Int): Single<BaseResult<List<MovieSum>>> {
        return db.popularMovieDao().getMovies().map {
            val data = popularMoviesEntityMapper.toData(it)
            BaseResult("", false, "", data)
        }
    }

    override fun getUpcomingMovies(page: Int): Single<BaseResult<List<MovieSum>>> {
        return db.upcomingMovieDao().getMovies().map {
            val data = upcomingMoviesMapper.toData(it)
            BaseResult("", false, "", data)
        }
    }

    override fun getDetailMovie(movieId: Long): Single<BaseResult<Movie>> {
        return db.movieGenreDao().getMovie(movieId).map {
            BaseResult("", false, "", movieDetailMapper.toData(it))
        }
    }

    override fun getMovieGenres(): Single<BaseResult<List<Genre>>> {
        return db.genreDao().getGenres().map {
            BaseResult("", false, "", it.map { g -> genreEntityMapper.toData(g) })
        }
    }

}