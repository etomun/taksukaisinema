package com.taksuinterview.kaisinema.common.di.module.data

import com.taksuinterview.kaisinema.data.repository.AuthRepoFactory
import com.taksuinterview.kaisinema.data.repository.MovieRepoFactory
import com.taksuinterview.kaisinema.domain.repository.AuthRepository
import com.taksuinterview.kaisinema.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module

@Module(includes = [LocalDataModule::class, RemoteDataModule::class])
internal abstract class DataModule {
    @Binds
    abstract fun authRepository(authRepoFactory: AuthRepoFactory): AuthRepository

    @Binds
    abstract fun movieRepository(movieRepoFactory: MovieRepoFactory): MovieRepository
}