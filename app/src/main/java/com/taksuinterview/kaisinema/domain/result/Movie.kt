package com.taksuinterview.kaisinema.domain.result

class Movie(
    val adult: Boolean,
    val backdropLarge: String,
    val backdropOriginal: String,
    val backdropSmall: String,
    val budget: Long,
    val genres: List<Genre>,
    val homepage: String,
    val id: Long,
    val imdbId: String,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterLarge: String,
    val posterOriginal: String,
    val posterSmall: String,
    val releaseDate: String,
    val revenue: Long,
    val runtime: Long,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Long
)