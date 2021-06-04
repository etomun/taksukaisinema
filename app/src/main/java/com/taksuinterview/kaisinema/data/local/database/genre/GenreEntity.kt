package com.taksuinterview.kaisinema.data.local.database.genre

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = GenreEntity.TABLE_NAME)
class GenreEntity(
    @ColumnInfo(name = C_ID)
    @PrimaryKey
    val id: Long,
    val genreName: String
) {
    companion object {
        const val TABLE_NAME = "UbIILjYwc5YvSj3YnFziea1IB8tvckBY"
        const val C_ID = "gP6snvC0RT2lNcCDGHuUqxJ5wdpNEsu7"
    }
}