package com.taksuinterview.kaisinema.data.local.database.genre

import androidx.room.Dao
import androidx.room.Query
import com.taksuinterview.kaisinema.data.local.base.BaseDao
import io.reactivex.Single

@Dao
interface GenreDao : BaseDao<GenreEntity> {
    @Query("select * from ${GenreEntity.TABLE_NAME}")
    fun getGenres(): Single<List<GenreEntity>>

    @Query("select * from ${GenreEntity.TABLE_NAME} where ${GenreEntity.C_ID} = :genreId")
    fun getGenre(genreId: Long): Single<GenreEntity>
}