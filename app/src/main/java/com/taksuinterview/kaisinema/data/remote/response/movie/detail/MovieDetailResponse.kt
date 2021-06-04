package com.taksuinterview.kaisinema.data.remote.response.movie.detail

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class MovieDetailResponse {
    @SerializedName("adult")
    @Expose
    var adult = false

    @SerializedName("backdrop_path")
    @Expose
    var backdropPath: String? = null

    @SerializedName("belongs_to_collection")
    @Expose
    var belongsToCollection: Any? = null

    @SerializedName("budget")
    @Expose
    var budget: Long = 0

    @SerializedName("genres")
    @Expose
    var genres: List<GenreResponse>? = null

    @SerializedName("homepage")
    @Expose
    var homepage: String? = null

    @SerializedName("id")
    @Expose
    var id: Long = 0

    @SerializedName("imdb_id")
    @Expose
    var imdbId: String? = null

    @SerializedName("original_language")
    @Expose
    var originalLanguage: String? = null

    @SerializedName("original_title")
    @Expose
    var originalTitle: String? = null

    @SerializedName("overview")
    @Expose
    var overview: String? = null

    @SerializedName("popularity")
    @Expose
    var popularity = 0.0

    @SerializedName("poster_path")
    @Expose
    var posterPath: String? = null

    @SerializedName("release_date")
    @Expose
    var releaseDate: String? = null

    @SerializedName("revenue")
    @Expose
    var revenue: Long = 0

    @SerializedName("runtime")
    @Expose
    var runtime: Long = 0

    @SerializedName("status")
    @Expose
    var status: String? = null

    @SerializedName("tagline")
    @Expose
    var tagline: String? = null

    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("video")
    @Expose
    var video = false

    @SerializedName("vote_average")
    @Expose
    var voteAverage = 0.0

    @SerializedName("vote_count")
    @Expose
    var voteCount: Long = 0
}