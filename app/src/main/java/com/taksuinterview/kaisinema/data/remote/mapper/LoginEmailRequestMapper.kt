package com.taksuinterview.kaisinema.data.remote.mapper

import com.taksuinterview.kaisinema.data.base.DataMapper
import com.taksuinterview.kaisinema.data.remote.request.auth.LoginEmailRequest
import com.taksuinterview.kaisinema.domain.param.LoginEmailParam
import javax.inject.Inject

class LoginEmailRequestMapper @Inject internal constructor() :
    DataMapper<LoginEmailRequest, LoginEmailParam> {
    override fun fromData(data: LoginEmailParam): LoginEmailRequest {
        val result = LoginEmailRequest()
        result.userEmail = data.email
        result.userPassword = data.password
        return result
    }

    override fun toData(source: LoginEmailRequest): LoginEmailParam {
        throw UnsupportedOperationException()
    }
}