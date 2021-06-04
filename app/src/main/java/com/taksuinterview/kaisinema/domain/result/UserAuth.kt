package com.taksuinterview.kaisinema.domain.result

data class UserAuth(
    var id: Long,
    var email: String,
    var authToken: String,
    var name: String,
    var gender: String
)