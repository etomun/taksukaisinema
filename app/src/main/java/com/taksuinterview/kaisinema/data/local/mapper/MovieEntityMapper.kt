package com.taksuinterview.kaisinema.data.local.mapper

import com.taksuinterview.kaisinema.data.base.DataMapper
import com.taksuinterview.kaisinema.data.local.database.moviedetail.MovieEntity
import com.taksuinterview.kaisinema.domain.result.Genre
import com.taksuinterview.kaisinema.domain.result.Movie
import javax.inject.Inject

class MovieEntityMapper @Inject internal constructor() :
    DataMapper<MovieEntity, Movie> {

    override fun fromData(data: Movie): MovieEntity {
        return MovieEntity(
            data.adult,
            data.backdropLarge,
            data.backdropOriginal,
            data.backdropSmall,
            data.budget,
            data.homepage,
            data.id,
            data.imdbId,
            data.originalLanguage,
            data.originalTitle,
            data.overview,
            data.popularity,
            data.posterLarge,
            data.posterOriginal,
            data.posterSmall,
            data.releaseDate,
            data.revenue,
            data.runtime,
            data.status,
            data.tagline,
            data.title,
            data.video,
            data.voteAverage,
            data.voteCount
        )
    }

    override fun toData(source: MovieEntity): Movie {
        val emptyGenres: ArrayList<Genre> = arrayListOf()
        return Movie(
            source.adult,
            source.backdropLarge,
            source.backdropOriginal,
            source.backdropSmall,
            source.budget,
            emptyGenres,
            source.homepage,
            source.id,
            source.imdbId,
            source.originalLanguage,
            source.originalTitle,
            source.overview,
            source.popularity,
            source.posterLarge,
            source.posterOriginal,
            source.posterSmall,
            source.releaseDate,
            source.revenue,
            source.runtime,
            source.status,
            source.tagline,
            source.title,
            source.video,
            source.voteAverage,
            source.voteCount
        )
    }
}