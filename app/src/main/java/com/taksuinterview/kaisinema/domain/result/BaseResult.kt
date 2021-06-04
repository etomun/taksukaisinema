package com.taksuinterview.kaisinema.domain.result

data class BaseResult<T>(
    val errorCode: String,
    val isError: Boolean,
    val message: String,
    val data: T?
)