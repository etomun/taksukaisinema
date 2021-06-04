package com.taksuinterview.kaisinema.data.local.database.upcomingmovie

import androidx.room.Dao
import androidx.room.Query
import com.taksuinterview.kaisinema.data.local.base.BaseDao
import io.reactivex.Single

@Dao
interface UpcomingMovieDao : BaseDao<UpcomingMovieEntity> {
    @Query("select * from  ${UpcomingMovieEntity.TABLE_NAME}")
    fun getMovies(): Single<List<UpcomingMovieEntity>>

    @Query("delete from  ${UpcomingMovieEntity.TABLE_NAME}")
    fun clearTable(): Int
}