package com.taksuinterview.kaisinema.data.local.database.moviedetail

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.taksuinterview.kaisinema.data.local.database.genre.GenreEntity

data class MovieWithGenre(
    @Embedded
    val movie: MovieEntity,

    @Relation(
        parentColumn = MovieEntity.C_ID,
        entityColumn = GenreEntity.C_ID,
        associateBy = Junction(MovieGenreCrossEntity::class)
    )
    val genres: List<GenreEntity>

)