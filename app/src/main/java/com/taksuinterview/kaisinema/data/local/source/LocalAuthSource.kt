package com.taksuinterview.kaisinema.data.local.source

import com.taksuinterview.kaisinema.data.local.preference.AppPreference.AuthPref
import com.taksuinterview.kaisinema.domain.param.LoginEmailParam
import com.taksuinterview.kaisinema.domain.param.SignUpParam
import com.taksuinterview.kaisinema.domain.repository.AuthRepository.DataSource
import com.taksuinterview.kaisinema.domain.result.BaseResult
import com.taksuinterview.kaisinema.domain.result.UserAuth
import io.reactivex.Observable
import javax.inject.Inject

class LocalAuthSource @Inject internal constructor(private val authPref: AuthPref) : DataSource {
    override fun persistAuth(auth: UserAuth) {
        authPref.setAuthToken(auth.authToken)
        authPref.setUid(auth.id)
        authPref.setEmail(auth.email)
    }

    override fun isLogin(): Boolean {
        return authPref.getAuthToken().isNotEmpty() && authPref.getUid() > 0
    }

    override fun loginByEmail(loginEmailParam: LoginEmailParam): Observable<BaseResult<UserAuth>> {
        throw UnsupportedOperationException()
    }

    override fun signUp(signUpParam: SignUpParam): Observable<BaseResult<Boolean>> {
        throw UnsupportedOperationException()
    }

    override fun requestNewPassword(email: String): Observable<BaseResult<Boolean>> {
        throw UnsupportedOperationException()
    }

    override fun verifyResetToken(token: String): Observable<BaseResult<Boolean>> {
        throw UnsupportedOperationException()
    }

    override fun resetPassword(token: String, password: String): Observable<BaseResult<Boolean>> {
        throw UnsupportedOperationException()
    }

    override fun logout(): Observable<Boolean> {
        authPref.setAuthToken("")
        authPref.setUid(-1L)
        authPref.setEmail("")
        authPref.setName("")
        authPref.setGender("")
        return Observable.just(true)
    }

    override fun getAuth(): UserAuth {
        return UserAuth(
            authPref.getUid(),
            authPref.getEmail(),
            authPref.getAuthToken(),
            authPref.getName(),
            authPref.getGender()
        )
    }

    override fun rememberEmail(email: String, password: String) {
        authPref.rememberEmail(email, password)
    }

    override fun getRememberedEmail(): Pair<String, String> {
        return authPref.getRememberEmail()
    }

    override fun clearRememberedEmail() {
        authPref.clearRememberedEmail()
    }

}