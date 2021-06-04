package com.taksuinterview.kaisinema.data.remote.source

import com.taksuinterview.kaisinema.data.remote.api.AuthApi
import com.taksuinterview.kaisinema.data.remote.mapper.BaseResponseMapper
import com.taksuinterview.kaisinema.data.remote.mapper.LoginEmailRequestMapper
import com.taksuinterview.kaisinema.data.remote.mapper.LoginResponseMapper
import com.taksuinterview.kaisinema.data.remote.mapper.SignUpRequestMapper
import com.taksuinterview.kaisinema.domain.param.LoginEmailParam
import com.taksuinterview.kaisinema.domain.param.SignUpParam
import com.taksuinterview.kaisinema.domain.repository.AuthRepository.DataSource
import com.taksuinterview.kaisinema.domain.result.BaseResult
import com.taksuinterview.kaisinema.domain.result.UserAuth
import io.reactivex.Observable
import javax.inject.Inject

class RemoteAuthSource @Inject internal constructor(
    private val authApi: AuthApi,
    private val baseResponseMapper: BaseResponseMapper<Any>,
    private val signUpRequestMapper: SignUpRequestMapper,
    private val loginEmailRequestMapper: LoginEmailRequestMapper,
    private val loginResponseMapper: LoginResponseMapper
) : DataSource {
    override fun persistAuth(auth: UserAuth) {
        throw UnsupportedOperationException()
    }

    override fun isLogin(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun loginByEmail(loginEmailParam: LoginEmailParam): Observable<BaseResult<UserAuth>> {
        return authApi.loginEmail(loginEmailRequestMapper.fromData(loginEmailParam))
            .map { loginResponseMapper.toData(it) }
    }

    override fun signUp(signUpParam: SignUpParam): Observable<BaseResult<Boolean>> {
        return authApi.signUp(signUpRequestMapper.fromData(signUpParam))
            .map { baseResponseMapper.toData(it) }
    }

    override fun requestNewPassword(email: String): Observable<BaseResult<Boolean>> {
        return authApi.requestResetPassword(email)
            .map { baseResponseMapper.toData(it) }
    }

    override fun verifyResetToken(token: String): Observable<BaseResult<Boolean>> {
        return authApi.checkResetPasswordToken(token)
            .map { baseResponseMapper.toData(it) }
    }

    override fun resetPassword(token: String, password: String): Observable<BaseResult<Boolean>> {
        return authApi.resetPassword(token, password, password)
            .map { baseResponseMapper.toData(it) }
    }

    override fun logout(): Observable<Boolean> {
        throw UnsupportedOperationException()
    }

    override fun getAuth(): UserAuth {
        throw UnsupportedOperationException()
    }

    override fun rememberEmail(email: String, password: String) {
        throw UnsupportedOperationException()
    }

    override fun getRememberedEmail(): Pair<String, String> {
        throw UnsupportedOperationException()
    }

    override fun clearRememberedEmail() {
        throw UnsupportedOperationException()
    }
}