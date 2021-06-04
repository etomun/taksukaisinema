package com.taksuinterview.kaisinema.common.util.http

import com.taksuinterview.kaisinema.BuildConfig
import com.taksuinterview.kaisinema.common.util.constant.Api
import com.taksuinterview.kaisinema.data.local.preference.AppPreference
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject


class AuthRequestInterceptor @Inject constructor(private val authPref: AppPreference.AuthPref) :
    Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val url = request.url.newBuilder()
            .addQueryParameter(Api.API_KEY, BuildConfig.API_KEY)
            .build()

        val requestBuilder = request.newBuilder()
//            .addHeader(Api.API_KEY, BuildConfig.API_KEY)
            .url(url)

//        if (request.header(Api.HEADER_NO_AUTHENTICATION) == null) {
//            val bearerToken = "Bearer " + authPref.getAuthToken()
//            requestBuilder.addHeader(Api.HEADER_AUTHORIZATION, bearerToken)
//        }

        return chain.proceed(requestBuilder.build())
    }

}