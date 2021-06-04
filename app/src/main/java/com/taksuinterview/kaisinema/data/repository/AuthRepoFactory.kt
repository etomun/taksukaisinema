package com.taksuinterview.kaisinema.data.repository

import com.taksuinterview.kaisinema.common.di.qualifier.data.LocalData
import com.taksuinterview.kaisinema.common.di.qualifier.data.RemoteData
import com.taksuinterview.kaisinema.data.base.BaseRepository
import com.taksuinterview.kaisinema.domain.param.LoginEmailParam
import com.taksuinterview.kaisinema.domain.param.SignUpParam
import com.taksuinterview.kaisinema.domain.repository.AuthRepository
import com.taksuinterview.kaisinema.domain.repository.AuthRepository.DataSource
import com.taksuinterview.kaisinema.domain.result.BaseResult
import com.taksuinterview.kaisinema.domain.result.UserAuth
import io.reactivex.Observable
import javax.inject.Inject

class AuthRepoFactory @Inject constructor(
    @LocalData localData: DataSource,
    @RemoteData remoteData: DataSource
) :
    BaseRepository<DataSource>(localData, remoteData),
    AuthRepository {
    override fun isLogin(): Boolean {
        return localData.isLogin()
    }

    override fun loginByEmail(loginEmailParam: LoginEmailParam): Observable<BaseResult<UserAuth>> {
        checkRemoteData()
        return remoteData!!.loginByEmail(loginEmailParam)
            .doOnNext { it.data?.let { userAuth -> localData.persistAuth(userAuth) } }
    }

    override fun signUp(signUpParam: SignUpParam): Observable<BaseResult<Boolean>> {
        checkRemoteData()
        return remoteData!!.signUp(signUpParam)
    }

    override fun requestNewPassword(email: String): Observable<BaseResult<Boolean>> {
        checkRemoteData()
        return remoteData!!.requestNewPassword(email)
    }

    override fun verifyResetToken(token: String): Observable<BaseResult<Boolean>> {
        checkRemoteData()
        return remoteData!!.verifyResetToken(token)
    }

    override fun resetPassword(
        token: String, password: String
    ): Observable<BaseResult<Boolean>> {
        checkRemoteData()
        return remoteData!!.resetPassword(token, password)
    }

    override fun logout(): Observable<Boolean> {
        return localData.logout()
    }

    override fun getAuth(): UserAuth {
        return localData.getAuth()
    }

    override fun rememberEmail(email: String, password: String) {
        localData.rememberEmail(email, password)
    }

    override fun getRememberedEmail(): Pair<String, String> {
        return localData.getRememberedEmail()
    }

    override fun clearRememberedEmail() {
        return localData.clearRememberedEmail()
    }
}