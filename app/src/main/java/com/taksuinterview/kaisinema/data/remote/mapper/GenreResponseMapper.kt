package com.taksuinterview.kaisinema.data.remote.mapper

import com.taksuinterview.kaisinema.data.base.DataMapper
import com.taksuinterview.kaisinema.data.remote.response.movie.detail.GenreResponse
import com.taksuinterview.kaisinema.domain.result.Genre
import javax.inject.Inject

class GenreResponseMapper @Inject internal constructor() :
    DataMapper<GenreResponse, Genre> {
    override fun fromData(data: Genre): GenreResponse {
        throw UnsupportedOperationException()
    }

    override fun toData(source: GenreResponse): Genre {
        return Genre(source.id, source.name.orEmpty())
    }
}