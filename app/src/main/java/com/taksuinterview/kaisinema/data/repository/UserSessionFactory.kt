package com.taksuinterview.kaisinema.data.repository

import com.taksuinterview.kaisinema.domain.repository.AuthRepository
import com.taksuinterview.kaisinema.domain.repository.UserSession
import io.reactivex.Observable
import javax.inject.Inject

class UserSessionFactory @Inject internal constructor(private val authRepository: AuthRepository) :
    UserSession {

    override fun isLogin(): Boolean = authRepository.isLogin()

    override fun doLogout(): Observable<Boolean> = authRepository.logout()
}