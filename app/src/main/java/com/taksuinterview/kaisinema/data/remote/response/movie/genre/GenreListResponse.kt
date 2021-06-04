package com.taksuinterview.kaisinema.data.remote.response.movie.genre

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GenreListResponse {
    @SerializedName("genres")
    @Expose
    var genres: List<GenreResponse>? = null
}