package com.taksuinterview.kaisinema.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.taksuinterview.kaisinema.data.local.database.genre.GenreDao
import com.taksuinterview.kaisinema.data.local.database.genre.GenreEntity
import com.taksuinterview.kaisinema.data.local.database.moviedetail.MovieDao
import com.taksuinterview.kaisinema.data.local.database.moviedetail.MovieEntity
import com.taksuinterview.kaisinema.data.local.database.moviedetail.MovieGenreCrossDao
import com.taksuinterview.kaisinema.data.local.database.moviedetail.MovieGenreCrossEntity
import com.taksuinterview.kaisinema.data.local.database.popularmovie.PopularMovieDao
import com.taksuinterview.kaisinema.data.local.database.popularmovie.PopularMovieEntity
import com.taksuinterview.kaisinema.data.local.database.upcomingmovie.UpcomingMovieDao
import com.taksuinterview.kaisinema.data.local.database.upcomingmovie.UpcomingMovieEntity

@Database(
    version = AppDatabase.DB_VERSION,
    exportSchema = false,
    entities = [
        UpcomingMovieEntity::class,
        PopularMovieEntity::class,
        MovieEntity::class,
        GenreEntity::class,
        MovieGenreCrossEntity::class
    ]
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun upcomingMovieDao(): UpcomingMovieDao
    abstract fun popularMovieDao(): PopularMovieDao
    abstract fun movieDao(): MovieDao
    abstract fun genreDao(): GenreDao
    abstract fun movieGenreDao(): MovieGenreCrossDao

    companion object {
        const val DB_NAME = "DGvC3freBqAepnVI9WX38NkIeVAY7TyP"
        const val DB_VERSION = 3
    }

}