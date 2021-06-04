package com.taksuinterview.kaisinema.common.di.module.data

import com.taksuinterview.kaisinema.common.di.scope.ApplicationScope
import com.taksuinterview.kaisinema.data.remote.api.AuthApi
import com.taksuinterview.kaisinema.data.remote.api.GenreApi
import com.taksuinterview.kaisinema.data.remote.api.MovieApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ApiModule {
    @ApplicationScope
    @Provides
    fun authApi(retrofit: Retrofit): AuthApi {
        return retrofit.create(AuthApi::class.java)
    }

    @ApplicationScope
    @Provides
    fun movieApi(retrofit: Retrofit): MovieApi {
        return retrofit.create(MovieApi::class.java)
    }

    @ApplicationScope
    @Provides
    fun genreApi(retrofit: Retrofit): GenreApi {
        return retrofit.create(GenreApi::class.java)
    }

}