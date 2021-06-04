package com.taksuinterview.kaisinema.data.local.mapper

import com.taksuinterview.kaisinema.data.base.DataMapper
import com.taksuinterview.kaisinema.data.local.database.popularmovie.PopularMovieEntity
import com.taksuinterview.kaisinema.domain.result.MovieSum

import javax.inject.Inject

class PopularMoviesEntityMapper @Inject internal constructor(private val popularMovieMapper: PopularMovieEntityMapper) :
    DataMapper<List<PopularMovieEntity>, List<MovieSum>> {

    override fun fromData(data: List<MovieSum>): List<PopularMovieEntity> {
        val result: ArrayList<PopularMovieEntity> = arrayListOf()
        data.map { result.add(popularMovieMapper.fromData(it)) }
        return result
    }

    override fun toData(source: List<PopularMovieEntity>): List<MovieSum> {
        val result: ArrayList<MovieSum> = arrayListOf()
        source.map { result.add(popularMovieMapper.toData(it)) }
        return result
    }
}