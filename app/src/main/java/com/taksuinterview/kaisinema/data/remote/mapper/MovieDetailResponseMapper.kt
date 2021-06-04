package com.taksuinterview.kaisinema.data.remote.mapper

import com.taksuinterview.kaisinema.common.util.helper.AppConfig
import com.taksuinterview.kaisinema.common.util.state.ImageSize
import com.taksuinterview.kaisinema.data.base.DataMapper
import com.taksuinterview.kaisinema.data.remote.response.movie.detail.MovieDetailResponse
import com.taksuinterview.kaisinema.domain.result.BaseResult
import com.taksuinterview.kaisinema.domain.result.Genre
import com.taksuinterview.kaisinema.domain.result.Movie
import javax.inject.Inject

class MovieDetailResponseMapper @Inject internal constructor(
    private val appConfig: AppConfig,
    private val genreResponseMapper: GenreResponseMapper
) :
    DataMapper<MovieDetailResponse, BaseResult<Movie>> {
    override fun fromData(data: BaseResult<Movie>): MovieDetailResponse {
        throw UnsupportedOperationException()
    }

    override fun toData(source: MovieDetailResponse): BaseResult<Movie> {
        val genres: ArrayList<Genre> = arrayListOf()
        source.genres?.forEach { genres.add(genreResponseMapper.toData(it)) }

        val data = Movie(
            source.adult,
            appConfig.generateBackdropUrl(source.backdropPath.orEmpty(), ImageSize.LARGE),
            appConfig.generateBackdropUrl(source.backdropPath.orEmpty(), ImageSize.ORIGINAL),
            appConfig.generateBackdropUrl(source.backdropPath.orEmpty(), ImageSize.SMALL),
            source.budget,
            genres,
            source.homepage.orEmpty(),
            source.id,
            source.imdbId.orEmpty(),
            source.originalLanguage.orEmpty(),
            source.originalTitle.orEmpty(),
            source.overview.orEmpty(),
            source.popularity,
            appConfig.generatePosterUrl(source.posterPath.orEmpty(), ImageSize.LARGE),
            appConfig.generatePosterUrl(source.posterPath.orEmpty(), ImageSize.ORIGINAL),
            appConfig.generatePosterUrl(source.posterPath.orEmpty(), ImageSize.SMALL),
            source.releaseDate.orEmpty(),
            source.revenue,
            source.runtime,
            source.status.orEmpty(),
            source.tagline.orEmpty(),
            source.originalTitle.orEmpty(),
            source.video,
            source.voteAverage,
            source.voteCount
        )

        return BaseResult("", false, "", data)
    }
}