package com.taksuinterview.kaisinema.data.base

interface DataMapper<S, D> {
    @Throws(Exception::class)
    fun fromData(data: D): S

    @Throws(Exception::class)
    fun toData(source: S): D
}