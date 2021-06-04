package com.taksuinterview.kaisinema.data.remote.mapper

import com.taksuinterview.kaisinema.data.base.DataMapper
import com.taksuinterview.kaisinema.data.remote.response.movie.genre.GenreListResponse
import com.taksuinterview.kaisinema.domain.result.BaseResult
import com.taksuinterview.kaisinema.domain.result.Genre
import javax.inject.Inject

class GenreListResponseMapper @Inject internal constructor() :
    DataMapper<GenreListResponse, BaseResult<List<Genre>>> {
    override fun fromData(data: BaseResult<List<Genre>>): GenreListResponse {
        throw UnsupportedOperationException()
    }

    override fun toData(source: GenreListResponse): BaseResult<List<Genre>> {
        val results: ArrayList<Genre> = arrayListOf()
        return if (source.genres.isNullOrEmpty()) {
            BaseResult("", true, "No Data", null)
        } else {
            source.genres!!.forEach {
                results.add(Genre(it.id, it.name.orEmpty()))
            }
            BaseResult("", false, "", results)
        }

    }
}