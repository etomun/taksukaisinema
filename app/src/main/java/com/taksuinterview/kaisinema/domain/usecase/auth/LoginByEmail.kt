package com.taksuinterview.kaisinema.domain.usecase.auth

import com.taksuinterview.kaisinema.domain.param.LoginEmailParam
import com.taksuinterview.kaisinema.domain.repository.AuthRepository
import com.taksuinterview.kaisinema.domain.result.BaseResult
import com.taksuinterview.kaisinema.domain.result.UserAuth
import com.taksuinterview.kaisinema.domain.usecase.UseCase
import io.reactivex.Observable
import javax.inject.Inject

class LoginByEmail @Inject internal constructor(private val authRepository: AuthRepository) :
    UseCase<Observable<BaseResult<UserAuth>>, LoginEmailParam> {

    override fun execute(param: LoginEmailParam): Observable<BaseResult<UserAuth>> {
        return authRepository.loginByEmail(param)
    }

}