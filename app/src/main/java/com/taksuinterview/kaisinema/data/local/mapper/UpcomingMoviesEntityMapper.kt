package com.taksuinterview.kaisinema.data.local.mapper

import com.taksuinterview.kaisinema.data.base.DataMapper
import com.taksuinterview.kaisinema.data.local.database.upcomingmovie.UpcomingMovieEntity
import com.taksuinterview.kaisinema.domain.result.MovieSum

import javax.inject.Inject

class UpcomingMoviesEntityMapper @Inject internal constructor(private val upcomingMovieMapper: UpcomingMovieEntityMapper) :
    DataMapper<List<UpcomingMovieEntity>, List<MovieSum>> {

    override fun fromData(data: List<MovieSum>): List<UpcomingMovieEntity> {
        val result: ArrayList<UpcomingMovieEntity> = arrayListOf()
        data.map { result.add(upcomingMovieMapper.fromData(it)) }
        return result
    }

    override fun toData(source: List<UpcomingMovieEntity>): List<MovieSum> {
        val result: ArrayList<MovieSum> = arrayListOf()
        source.map { result.add(upcomingMovieMapper.toData(it)) }
        return result
    }
}