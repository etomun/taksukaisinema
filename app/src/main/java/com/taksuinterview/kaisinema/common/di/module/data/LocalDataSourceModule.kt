package com.taksuinterview.kaisinema.common.di.module.data

import com.taksuinterview.kaisinema.common.di.qualifier.data.LocalData
import com.taksuinterview.kaisinema.data.local.source.LocalAuthSource
import com.taksuinterview.kaisinema.data.local.source.LocalMovieSource
import com.taksuinterview.kaisinema.domain.repository.AuthRepository
import com.taksuinterview.kaisinema.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module

@Module
internal abstract class LocalDataSourceModule {
    @Binds
    @LocalData
    abstract fun authSource(localAuthSource: LocalAuthSource): AuthRepository.DataSource

    @Binds
    @LocalData
    abstract fun movieSource(localMovieSource: LocalMovieSource): MovieRepository.DataSource

}