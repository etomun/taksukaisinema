package com.taksuinterview.kaisinema.data.remote.response.movie.genre

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GenreResponse {
    @SerializedName("id")
    @Expose
    var id: Long = 0

    @SerializedName("name")
    @Expose
    var name: String? = null
}