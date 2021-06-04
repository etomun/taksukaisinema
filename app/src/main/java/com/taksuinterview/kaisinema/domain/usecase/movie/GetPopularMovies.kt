package com.taksuinterview.kaisinema.domain.usecase.movie

import com.taksuinterview.kaisinema.domain.repository.MovieRepository
import com.taksuinterview.kaisinema.domain.result.BaseResult
import com.taksuinterview.kaisinema.domain.result.MovieSum
import com.taksuinterview.kaisinema.domain.usecase.UseCase
import io.reactivex.Single
import javax.inject.Inject

class GetPopularMovies @Inject internal constructor(private val movieRepository: MovieRepository) :
    UseCase<Single<BaseResult<List<MovieSum>>>, Int> {

    override fun execute(param: Int): Single<BaseResult<List<MovieSum>>> {
        return movieRepository.getPopularMovies(param)
    }

}