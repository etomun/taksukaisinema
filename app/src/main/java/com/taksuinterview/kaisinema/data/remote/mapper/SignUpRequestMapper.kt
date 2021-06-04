package com.taksuinterview.kaisinema.data.remote.mapper

import com.taksuinterview.kaisinema.data.base.DataMapper
import com.taksuinterview.kaisinema.data.remote.request.auth.SignUpRequest
import com.taksuinterview.kaisinema.domain.param.SignUpParam
import java.util.*
import javax.inject.Inject

class SignUpRequestMapper @Inject internal constructor() : DataMapper<SignUpRequest, SignUpParam> {
    override fun fromData(data: SignUpParam): SignUpRequest {
        val result = SignUpRequest()
        result.userEmail = data.userEmail
        result.userGender = data.userGender.lowercase(Locale.getDefault())
        result.userName = data.userName
        result.userPassword = data.userPassword
        result.userPhone = data.userPhone
        return result
    }

    override fun toData(source: SignUpRequest): SignUpParam {
        throw UnsupportedOperationException()
    }
}