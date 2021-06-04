package com.taksuinterview.kaisinema.data.local.base

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import io.reactivex.Completable
import io.reactivex.Single

interface BaseDao<T> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertReplace(obj: T): Single<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    fun insertReplace(obj: List<T>): Single<List<Long>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertIgnore(obj: T): Single<Long>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    @JvmSuppressWildcards
    fun insertIgnore(obj: List<T>): Single<List<Long>>

    @Update
    fun update(obj: T): Single<Int>

    @Update
    fun update(listObj: List<T>): Completable

    @Delete
    fun delete(obj: T): Single<Int>

    @Delete
    fun delete(listObj: List<T>): Single<Int>
}