package com.taksuinterview.kaisinema.common.di.module.data

import com.taksuinterview.kaisinema.common.di.qualifier.data.RemoteData
import com.taksuinterview.kaisinema.data.remote.source.RemoteAuthSource
import com.taksuinterview.kaisinema.data.remote.source.RemoteMovieSource
import com.taksuinterview.kaisinema.domain.repository.AuthRepository
import com.taksuinterview.kaisinema.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module

@Module
internal abstract class RemoteDataSourceModule {
    @Binds
    @RemoteData
    abstract fun authSource(remoteAuthSource: RemoteAuthSource): AuthRepository.DataSource

    @Binds
    @RemoteData
    abstract fun movieSource(remoteMovieSource: RemoteMovieSource): MovieRepository.DataSource
}