package com.taksuinterview.kaisinema.data.local.database.moviedetail

import androidx.room.Dao
import androidx.room.Query
import com.taksuinterview.kaisinema.data.local.base.BaseDao
import io.reactivex.Single

@Dao
interface MovieGenreCrossDao : BaseDao<MovieGenreCrossEntity> {
    @Query("select * from  ${MovieEntity.TABLE_NAME} where ${MovieEntity.C_ID} = :movieId")
    fun getMovie(movieId: Long): Single<MovieWithGenre>
}