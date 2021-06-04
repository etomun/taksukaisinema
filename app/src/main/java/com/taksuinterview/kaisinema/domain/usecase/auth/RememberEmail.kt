package com.taksuinterview.kaisinema.domain.usecase.auth

import com.taksuinterview.kaisinema.domain.repository.AuthRepository
import com.taksuinterview.kaisinema.domain.usecase.UseCase
import javax.inject.Inject

class RememberEmail @Inject internal constructor(private val authRepository: AuthRepository) :
    UseCase<Unit, Pair<String, String>> {
    override fun execute(param: Pair<String, String>) {
        return authRepository.rememberEmail(param.first, param.second)
    }

}