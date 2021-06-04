package com.taksuinterview.kaisinema.domain.repository

import io.reactivex.Observable

interface UserSession {
    fun isLogin(): Boolean
    fun doLogout(): Observable<Boolean>
}