package com.taksuinterview.kaisinema.domain.usecase.auth

import com.taksuinterview.kaisinema.domain.repository.AuthRepository
import com.taksuinterview.kaisinema.domain.result.UserAuth
import com.taksuinterview.kaisinema.domain.usecase.UseCase
import javax.inject.Inject

class GetAuthData @Inject internal constructor(private val authRepository: AuthRepository) :
    UseCase<UserAuth, Void?> {

    override fun execute(param: Void?): UserAuth {
        return authRepository.getAuth()
    }
}