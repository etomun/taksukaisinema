package com.taksuinterview.kaisinema.domain.usecase.movie

import com.taksuinterview.kaisinema.domain.repository.MovieRepository
import com.taksuinterview.kaisinema.domain.result.BaseResult
import com.taksuinterview.kaisinema.domain.result.Genre
import com.taksuinterview.kaisinema.domain.usecase.UseCase
import io.reactivex.Single
import javax.inject.Inject

class GetMovieGenres @Inject internal constructor(private val movieRepository: MovieRepository) :
    UseCase<Single<BaseResult<List<Genre>>>, Any?> {

    override fun execute(param: Any?): Single<BaseResult<List<Genre>>> {
        return movieRepository.getMovieGenres()
    }
}