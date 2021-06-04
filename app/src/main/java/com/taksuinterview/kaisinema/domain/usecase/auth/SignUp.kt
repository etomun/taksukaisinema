package com.taksuinterview.kaisinema.domain.usecase.auth

import com.taksuinterview.kaisinema.domain.param.SignUpParam
import com.taksuinterview.kaisinema.domain.repository.AuthRepository
import com.taksuinterview.kaisinema.domain.result.BaseResult
import com.taksuinterview.kaisinema.domain.usecase.UseCase
import io.reactivex.Observable
import javax.inject.Inject

class SignUp @Inject internal constructor(private val authRepository: AuthRepository) :
    UseCase<Observable<BaseResult<Boolean>>, SignUpParam> {

    override fun execute(param: SignUpParam): Observable<BaseResult<Boolean>> {
        return authRepository.signUp(param)
    }

}