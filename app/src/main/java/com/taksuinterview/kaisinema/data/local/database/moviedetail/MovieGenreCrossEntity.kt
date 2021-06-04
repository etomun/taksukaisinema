package com.taksuinterview.kaisinema.data.local.database.moviedetail

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.taksuinterview.kaisinema.data.local.database.genre.GenreEntity

@Entity(primaryKeys = [MovieEntity.C_ID, GenreEntity.C_ID])
class MovieGenreCrossEntity(
    @ColumnInfo(name = MovieEntity.C_ID)
    val movieId: Long,
    @ColumnInfo(name = GenreEntity.C_ID)
    val genreId: Long
)