package com.taksuinterview.kaisinema.domain.usecase.auth

import com.taksuinterview.kaisinema.domain.repository.AuthRepository
import com.taksuinterview.kaisinema.domain.usecase.UseCase
import javax.inject.Inject

class GetRememberedEmail @Inject internal constructor(private val authRepository: AuthRepository) :
    UseCase<Pair<String, String>, Unit?> {
    override fun execute(param: Unit?): Pair<String, String> {
        return authRepository.getRememberedEmail()
    }
}