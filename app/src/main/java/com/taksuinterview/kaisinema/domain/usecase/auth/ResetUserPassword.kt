package com.taksuinterview.kaisinema.domain.usecase.auth

import com.taksuinterview.kaisinema.domain.param.ResetPasswordParam
import com.taksuinterview.kaisinema.domain.repository.AuthRepository
import com.taksuinterview.kaisinema.domain.result.BaseResult
import com.taksuinterview.kaisinema.domain.usecase.UseCase
import io.reactivex.Observable
import javax.inject.Inject

class ResetUserPassword @Inject internal constructor(private val authRepository: AuthRepository) :
    UseCase<Observable<BaseResult<Boolean>>, ResetPasswordParam> {
    override fun execute(param: ResetPasswordParam): Observable<BaseResult<Boolean>> {
        return authRepository.resetPassword(param.token, param.password)
    }

}