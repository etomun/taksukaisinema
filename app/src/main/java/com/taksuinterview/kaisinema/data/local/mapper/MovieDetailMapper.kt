package com.taksuinterview.kaisinema.data.local.mapper

import com.taksuinterview.kaisinema.data.base.DataMapper
import com.taksuinterview.kaisinema.data.local.database.genre.GenreEntity
import com.taksuinterview.kaisinema.data.local.database.moviedetail.MovieWithGenre
import com.taksuinterview.kaisinema.domain.result.Genre
import com.taksuinterview.kaisinema.domain.result.Movie
import javax.inject.Inject

class MovieDetailMapper @Inject internal constructor(
    private val genreMapper: GenreEntityMapper,
    private val movieMapper: MovieEntityMapper
) :
    DataMapper<MovieWithGenre, Movie> {

    override fun fromData(data: Movie): MovieWithGenre {
        val genres: ArrayList<GenreEntity> = arrayListOf()
        data.genres.forEach { genres.add(genreMapper.fromData(it)) }
        return MovieWithGenre(movieMapper.fromData(data), genres)
    }

    override fun toData(source: MovieWithGenre): Movie {
        val genres: ArrayList<Genre> = arrayListOf()
        source.genres.forEach { genres.add(genreMapper.toData(it)) }

        val entity = source.movie
        return Movie(
            entity.adult,
            entity.backdropLarge,
            entity.backdropOriginal,
            entity.backdropSmall,
            entity.budget,
            genres,
            entity.homepage,
            entity.id,
            entity.imdbId,
            entity.originalLanguage,
            entity.originalTitle,
            entity.overview,
            entity.popularity,
            entity.posterLarge,
            entity.posterOriginal,
            entity.posterSmall,
            entity.releaseDate,
            entity.revenue,
            entity.runtime,
            entity.status,
            entity.tagline,
            entity.title,
            entity.video,
            entity.voteAverage,
            entity.voteCount
        )
    }
}