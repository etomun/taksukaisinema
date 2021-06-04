package com.taksuinterview.kaisinema.data.local.database.popularmovie

import androidx.room.Dao
import androidx.room.Query
import com.taksuinterview.kaisinema.data.local.base.BaseDao
import io.reactivex.Single

@Dao
interface PopularMovieDao : BaseDao<PopularMovieEntity> {
    @Query("select * from  ${PopularMovieEntity.TABLE_NAME}")
    fun getMovies(): Single<List<PopularMovieEntity>>

    @Query("delete from  ${PopularMovieEntity.TABLE_NAME}")
    fun clearTable(): Int
}