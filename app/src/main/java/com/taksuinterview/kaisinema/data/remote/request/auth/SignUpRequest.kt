package com.taksuinterview.kaisinema.data.remote.request.auth

import com.google.gson.annotations.SerializedName


class SignUpRequest {
    @SerializedName("userName")
    var userName: String? = ""

    @SerializedName("userEmail")
    var userEmail: String? = ""

    @SerializedName("userPhone")
    var userPhone: String? = ""

    @SerializedName("userPassword")
    var userPassword: String? = ""

    @SerializedName("userGender")
    var userGender: String? = ""
}