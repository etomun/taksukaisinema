package com.taksuinterview.kaisinema.domain.repository

import com.taksuinterview.kaisinema.domain.param.LoginEmailParam
import com.taksuinterview.kaisinema.domain.param.SignUpParam
import com.taksuinterview.kaisinema.domain.result.BaseResult
import com.taksuinterview.kaisinema.domain.result.UserAuth
import io.reactivex.Observable

interface AuthRepository {
    fun isLogin(): Boolean
    fun loginByEmail(loginEmailParam: LoginEmailParam): Observable<BaseResult<UserAuth>>
    fun signUp(signUpParam: SignUpParam): Observable<BaseResult<Boolean>>
    fun requestNewPassword(email: String): Observable<BaseResult<Boolean>>
    fun verifyResetToken(token: String): Observable<BaseResult<Boolean>>
    fun resetPassword(token: String, password: String): Observable<BaseResult<Boolean>>

    fun logout(): Observable<Boolean>
    fun getAuth(): UserAuth
    fun rememberEmail(email: String, password: String)
    fun getRememberedEmail(): Pair<String, String>
    fun clearRememberedEmail()

    interface DataSource :
        AuthRepository {
        fun persistAuth(auth: UserAuth)
    }
}