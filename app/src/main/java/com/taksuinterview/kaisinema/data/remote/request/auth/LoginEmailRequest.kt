package com.taksuinterview.kaisinema.data.remote.request.auth

import com.google.gson.annotations.SerializedName


class LoginEmailRequest {
    @SerializedName("userEmail")
    var userEmail: String? = ""

    @SerializedName("userPassword")
    var userPassword: String? = ""
}