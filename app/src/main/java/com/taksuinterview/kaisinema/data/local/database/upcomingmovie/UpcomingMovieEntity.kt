package com.taksuinterview.kaisinema.data.local.database.upcomingmovie

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = UpcomingMovieEntity.TABLE_NAME)
class UpcomingMovieEntity(
    val adult: Boolean,
    val backdropLarge: String,
    val backdropOriginal: String,
    val backdropSmall: String,
    @ColumnInfo(name = C_ID)
    @PrimaryKey
    var id: Long,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterLarge: String,
    val posterOriginal: String,
    val posterSmall: String,
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Long
) {
    companion object {
        const val TABLE_NAME = "zieaBYUbIILjYwc5Y1IB8tvckvSj3YnF"
        const val C_ID = "gP6snvC0RT2lNcCDGHuUqxJ5wdpNEsu7"
    }
}