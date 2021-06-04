package com.taksuinterview.kaisinema.domain.usecase.auth

import com.taksuinterview.kaisinema.domain.repository.AuthRepository
import com.taksuinterview.kaisinema.domain.result.BaseResult
import com.taksuinterview.kaisinema.domain.usecase.UseCase
import io.reactivex.Observable
import javax.inject.Inject

class RequestNewPassword @Inject internal constructor(private val authRepository: AuthRepository) :
    UseCase<Observable<BaseResult<Boolean>>, String> {

    override fun execute(param: String): Observable<BaseResult<Boolean>> {
        return authRepository.requestNewPassword(param)
    }

}