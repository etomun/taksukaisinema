package com.taksuinterview.kaisinema.data.remote.mapper

import com.taksuinterview.kaisinema.common.util.helper.AppConfig
import com.taksuinterview.kaisinema.common.util.state.ImageSize
import com.taksuinterview.kaisinema.data.base.DataMapper
import com.taksuinterview.kaisinema.data.remote.response.movie.list.MovieSumResponse
import com.taksuinterview.kaisinema.domain.result.MovieSum
import javax.inject.Inject

class MovieSumResponseMapper @Inject internal constructor(private val appConfig: AppConfig) :
    DataMapper<MovieSumResponse, MovieSum> {
    override fun fromData(data: MovieSum): MovieSumResponse {
        throw UnsupportedOperationException()
    }

    override fun toData(source: MovieSumResponse): MovieSum {
        return MovieSum(
            source.adult,
            appConfig.generateBackdropUrl(source.backdropPath.orEmpty(), ImageSize.LARGE),
            appConfig.generateBackdropUrl(source.backdropPath.orEmpty(), ImageSize.ORIGINAL),
            appConfig.generateBackdropUrl(source.backdropPath.orEmpty(), ImageSize.SMALL),
            source.id,
            source.originalLanguage.orEmpty(),
            source.originalTitle.orEmpty(),
            source.overview.orEmpty(),
            source.popularity,
            appConfig.generatePosterUrl(source.posterPath.orEmpty(), ImageSize.LARGE),
            appConfig.generatePosterUrl(source.posterPath.orEmpty(), ImageSize.ORIGINAL),
            appConfig.generatePosterUrl(source.posterPath.orEmpty(), ImageSize.SMALL),
            source.releaseDate.orEmpty(),
            source.originalTitle.orEmpty(),
            source.video,
            source.voteAverage,
            source.voteCount
        )
    }
}