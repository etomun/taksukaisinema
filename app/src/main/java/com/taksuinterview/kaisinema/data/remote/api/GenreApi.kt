package com.taksuinterview.kaisinema.data.remote.api

import com.taksuinterview.kaisinema.data.remote.response.movie.genre.GenreListResponse
import io.reactivex.Single
import retrofit2.http.GET

interface GenreApi {
    @GET("genre/movie/list")
    fun getMovieGenres(): Single<GenreListResponse>
}