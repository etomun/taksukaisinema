package com.taksuinterview.kaisinema.data.remote.mapper

import com.taksuinterview.kaisinema.data.base.DataMapper
import com.taksuinterview.kaisinema.data.remote.base.BaseResponse
import com.taksuinterview.kaisinema.data.remote.response.auth.LoginResponse
import com.taksuinterview.kaisinema.domain.result.BaseResult
import com.taksuinterview.kaisinema.domain.result.UserAuth
import javax.inject.Inject

class LoginResponseMapper @Inject internal constructor() :
    DataMapper<BaseResponse<LoginResponse>, BaseResult<UserAuth>> {
    override fun fromData(data: BaseResult<UserAuth>): BaseResponse<LoginResponse> {
        throw UnsupportedOperationException()
    }

    override fun toData(source: BaseResponse<LoginResponse>): BaseResult<UserAuth> {
        val userAuth: UserAuth? = if (source.data == null) {
            null
        } else {
            val resp = source.data!!
            UserAuth(
                id = resp.id,
                email = resp.email,
                authToken = resp.token,
                name = resp.name,
                gender = resp.gender
            )
        }
        return BaseResult(source.errorCode, source.isError(), source.message, userAuth)
    }
}