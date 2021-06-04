package com.taksuinterview.kaisinema.data.remote.response.movie.list

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class MovieListResponse {
    @SerializedName("page")
    @Expose
    var page: Long = 0

    @SerializedName("results")
    @Expose
    var results: List<MovieSumResponse>? = null
}