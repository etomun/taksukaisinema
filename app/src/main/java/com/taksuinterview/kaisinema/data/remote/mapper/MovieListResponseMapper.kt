package com.taksuinterview.kaisinema.data.remote.mapper

import com.taksuinterview.kaisinema.data.base.DataMapper
import com.taksuinterview.kaisinema.data.remote.response.movie.list.MovieListResponse
import com.taksuinterview.kaisinema.domain.result.BaseResult
import com.taksuinterview.kaisinema.domain.result.MovieSum
import javax.inject.Inject

class MovieListResponseMapper @Inject internal constructor(private val movieSumResponseMapper: MovieSumResponseMapper) :
    DataMapper<MovieListResponse, BaseResult<List<MovieSum>>> {
    override fun fromData(data: BaseResult<List<MovieSum>>): MovieListResponse {
        throw UnsupportedOperationException()
    }

    override fun toData(source: MovieListResponse): BaseResult<List<MovieSum>> {
        val results: ArrayList<MovieSum> = arrayListOf()
        return if (source.results.isNullOrEmpty()) {
            BaseResult("", true, "No Data", null)
        } else {
            source.results!!.forEach {
                results.add(movieSumResponseMapper.toData(it))
            }
            BaseResult("", false, "", results)
        }

    }
}