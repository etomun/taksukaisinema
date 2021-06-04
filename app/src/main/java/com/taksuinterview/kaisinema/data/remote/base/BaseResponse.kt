package com.taksuinterview.kaisinema.data.remote.base

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


open class BaseResponse<DATA> {
    @SerializedName("success")
    @Expose
    private var success: Int = 0

    @SerializedName("message")
    var message: String = ""

    @SerializedName("errorCode")
    var errorCode: String = ""

    @SerializedName("data")
    var data: DATA? = null

    fun isError(): Boolean = this.success != 1
}
