package com.taksuinterview.kaisinema.data.local.mapper

import com.taksuinterview.kaisinema.data.base.DataMapper
import com.taksuinterview.kaisinema.data.local.database.genre.GenreEntity
import com.taksuinterview.kaisinema.domain.result.Genre
import javax.inject.Inject

class GenreEntityMapper @Inject internal constructor() :
    DataMapper<GenreEntity, Genre> {

    override fun fromData(data: Genre): GenreEntity {
        return GenreEntity(data.id, data.name)
    }

    override fun toData(source: GenreEntity): Genre {
        return Genre(source.id, source.genreName)
    }
}