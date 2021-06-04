package com.taksuinterview.kaisinema.data.remote.api

import com.taksuinterview.kaisinema.data.remote.response.movie.detail.MovieDetailResponse
import com.taksuinterview.kaisinema.data.remote.response.movie.list.MovieListResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApi {
    @GET("movie/upcoming")
    fun getUpcomingMovies(): Single<MovieListResponse>

    @GET("movie/popular")
    fun getPopularMovies(): Single<MovieListResponse>

    @GET("movie/{movie_id}")
    fun getDetailMovie(@Path("movie_id") movieId: Long): Single<MovieDetailResponse>
}