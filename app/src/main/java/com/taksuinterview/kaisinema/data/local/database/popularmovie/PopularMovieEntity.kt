package com.taksuinterview.kaisinema.data.local.database.popularmovie

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = PopularMovieEntity.TABLE_NAME)
class PopularMovieEntity(
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
        const val TABLE_NAME = "kvSjzieaBYUbIILjYwc5Y1IB8tvc3YnF"
        const val C_ID = "uUqxJ5wdnvC0RT2lNcCDGHu7pNEsgP6s"
    }
}