package com.taksuinterview.kaisinema.data.local.mapper

import com.taksuinterview.kaisinema.data.base.DataMapper
import com.taksuinterview.kaisinema.data.local.database.popularmovie.PopularMovieEntity
import com.taksuinterview.kaisinema.domain.result.MovieSum
import javax.inject.Inject

class PopularMovieEntityMapper @Inject internal constructor() :
    DataMapper<PopularMovieEntity, MovieSum> {

    override fun fromData(data: MovieSum): PopularMovieEntity {
        return PopularMovieEntity(
            data.adult,
            data.backdropLarge,
            data.backdropOriginal,
            data.backdropSmall,
            data.id,
            data.originalLanguage,
            data.originalTitle,
            data.overview,
            data.popularity,
            data.posterLarge,
            data.posterOriginal,
            data.posterSmall,
            data.releaseDate,
            data.title,
            data.video,
            data.voteAverage,
            data.voteCount
        )
    }

    override fun toData(source: PopularMovieEntity): MovieSum {
        return MovieSum(
            source.adult,
            source.backdropLarge,
            source.backdropOriginal,
            source.backdropSmall,
            source.id,
            source.originalLanguage,
            source.originalTitle,
            source.overview,
            source.popularity,
            source.posterLarge,
            source.posterOriginal,
            source.posterSmall,
            source.releaseDate,
            source.title,
            source.video,
            source.voteAverage,
            source.voteCount
        )
    }
}