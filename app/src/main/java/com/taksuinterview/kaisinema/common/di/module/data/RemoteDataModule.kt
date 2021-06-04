package com.taksuinterview.kaisinema.common.di.module.data

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.taksuinterview.kaisinema.BuildConfig
import com.taksuinterview.kaisinema.common.di.qualifier.android.ApplicationContext
import com.taksuinterview.kaisinema.common.di.qualifier.config.AuthInterceptor
import com.taksuinterview.kaisinema.common.di.qualifier.config.LoggingInterceptor
import com.taksuinterview.kaisinema.common.di.qualifier.config.ResponseInterceptor
import com.taksuinterview.kaisinema.common.di.scope.ApplicationScope
import com.taksuinterview.kaisinema.common.util.framework.DeviceUtil
import com.taksuinterview.kaisinema.common.util.http.AuthRequestInterceptor
import com.taksuinterview.kaisinema.common.util.http.HttpResponseInterceptor
import com.taksuinterview.kaisinema.common.util.state.HttpState
import com.taksuinterview.kaisinema.data.local.preference.AppPreference
import dagger.Module
import dagger.Provides
import io.reactivex.subjects.PublishSubject
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


@Module(includes = [ApiModule::class, RemoteDataSourceModule::class])
internal class RemoteDataModule {
    @ApplicationScope
    @Provides
    fun converter(): Gson {
        return GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
            .create()
    }

    @Provides
    @LoggingInterceptor
    fun interceptor(): Interceptor {
        val logger = HttpLoggingInterceptor()
        logger.level =
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        return logger
    }

    @Provides
    @AuthInterceptor
    fun authInterceptor(authPref: AppPreference.AuthPref): Interceptor {
        return AuthRequestInterceptor(authPref)
    }

    @Provides
    @ResponseInterceptor
    fun responseInterceptor(
        deviceUtil: DeviceUtil,
        httpEvent: PublishSubject<Pair<HttpState, String>>
    ): Interceptor {
        return HttpResponseInterceptor(deviceUtil, httpEvent)
    }

    @ApplicationScope
    @Provides
    fun cache(@ApplicationContext context: Context): Cache {
        return Cache(context.cacheDir, 10 * 1024 * 1024)
    }

    @ApplicationScope
    @Provides
    fun okHttpClient(
        @LoggingInterceptor loggingInterceptor: Interceptor,
        @AuthInterceptor authInterceptor: Interceptor,
        @ResponseInterceptor responseInterceptor: Interceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor) /* Debug logging */
            .addInterceptor(authInterceptor) /* Add auth header for specific request */
            .addInterceptor(responseInterceptor) /* Check connectivity & http response error */
            .connectTimeout(8, TimeUnit.SECONDS)
            .readTimeout(8, TimeUnit.SECONDS)
            .writeTimeout(8, TimeUnit.SECONDS)
            .build()
    }

    @ApplicationScope
    @Provides
    fun retrofitApi(client: OkHttpClient, converter: Gson): Retrofit {
        return Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(converter))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .build()
    }
}