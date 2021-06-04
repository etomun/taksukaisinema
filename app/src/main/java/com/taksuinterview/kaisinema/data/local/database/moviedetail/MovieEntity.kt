package com.taksuinterview.kaisinema.data.local.database.moviedetail

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.taksuinterview.kaisinema.domain.result.Genre

@Entity(tableName = MovieEntity.TABLE_NAME)
class MovieEntity(
    val adult: Boolean,
    val backdropLarge: String,
    val backdropOriginal: String,
    val backdropSmall: String,
    val budget: Long,
    val homepage: String,
    @ColumnInfo(name = C_ID)
    @PrimaryKey
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
) {
    companion object {
        const val TABLE_NAME = "vSj3YnFziea1IB8tvckBYUbIILjYwc5Y"
        const val C_ID = "NcCDGHuUqxJ5wdpNEsu7gP6snvC0RT2l"
    }
}