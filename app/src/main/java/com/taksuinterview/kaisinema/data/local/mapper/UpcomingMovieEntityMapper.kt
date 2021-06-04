package com.taksuinterview.kaisinema.data.local.mapper

import com.taksuinterview.kaisinema.data.base.DataMapper
import com.taksuinterview.kaisinema.data.local.database.upcomingmovie.UpcomingMovieEntity
import com.taksuinterview.kaisinema.domain.result.MovieSum
import javax.inject.Inject

class UpcomingMovieEntityMapper @Inject internal constructor() :
    DataMapper<UpcomingMovieEntity, MovieSum> {

    override fun fromData(data: MovieSum): UpcomingMovieEntity {
        return UpcomingMovieEntity(
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

    override fun toData(source: UpcomingMovieEntity): MovieSum {
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