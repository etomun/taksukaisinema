package com.taksuinterview.kaisinema.domain.usecase.auth

import com.taksuinterview.kaisinema.domain.repository.AuthRepository
import com.taksuinterview.kaisinema.domain.usecase.UseCase
import javax.inject.Inject

class ClearRememberedEmail @Inject internal constructor(private val authRepository: AuthRepository) :
    UseCase<Unit, Unit?> {
    override fun execute(param: Unit?) {
        authRepository.clearRememberedEmail()
    }
}