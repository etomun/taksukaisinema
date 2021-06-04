package com.taksuinterview.kaisinema.data.remote.response.auth

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class LoginResponse {
    @SerializedName("token")
    @Expose
    var token: String = ""

    @SerializedName("id")
    @Expose
    var id: Long = 0

    @SerializedName("email")
    @Expose
    var email: String = ""

    @SerializedName("name")
    @Expose
    var name: String = ""

    @SerializedName("gender")
    @Expose
    var gender: String = ""
}