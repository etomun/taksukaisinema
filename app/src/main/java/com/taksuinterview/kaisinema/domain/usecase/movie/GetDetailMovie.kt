package com.taksuinterview.kaisinema.domain.usecase.movie

import com.taksuinterview.kaisinema.domain.repository.MovieRepository
import com.taksuinterview.kaisinema.domain.result.BaseResult
import com.taksuinterview.kaisinema.domain.result.Movie
import com.taksuinterview.kaisinema.domain.usecase.UseCase
import io.reactivex.Single
import javax.inject.Inject

class GetDetailMovie @Inject internal constructor(private val movieRepository: MovieRepository) :
    UseCase<Single<BaseResult<Movie>>, Long> {

    override fun execute(param: Long): Single<BaseResult<Movie>> {
        return movieRepository.getDetailMovie(param)
    }

}