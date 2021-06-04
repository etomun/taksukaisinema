package com.taksuinterview.kaisinema.data.remote.mapper

import com.taksuinterview.kaisinema.data.base.DataMapper
import com.taksuinterview.kaisinema.data.remote.base.BaseResponse
import com.taksuinterview.kaisinema.domain.result.BaseResult
import javax.inject.Inject

class BaseResponseMapper<T> @Inject internal constructor() :
    DataMapper<BaseResponse<T>, BaseResult<Boolean>> {
    override fun fromData(data: BaseResult<Boolean>): BaseResponse<T> {
        throw UnsupportedOperationException()
    }

    override fun toData(source: BaseResponse<T>): BaseResult<Boolean> {
        return BaseResult(
            source.errorCode,
            source.isError(),
            source.message,
            !source.isError()
        )
    }
}