package com.taksuinterview.kaisinema.common.util.http

import com.taksuinterview.kaisinema.common.util.constant.ErrorCode
import com.taksuinterview.kaisinema.common.util.framework.DeviceUtil
import com.taksuinterview.kaisinema.common.util.state.HttpState
import io.reactivex.subjects.PublishSubject
import okhttp3.Interceptor
import okhttp3.Response
import org.json.JSONObject
import java.io.IOException
import java.net.HttpURLConnection
import javax.inject.Inject


class HttpResponseInterceptor @Inject internal constructor(
    private val deviceUtil: DeviceUtil,
    private val httpEvent: PublishSubject<Pair<HttpState, String>>
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())
        if (!deviceUtil.isOnline()) {
            httpEvent.onNext(Pair(HttpState.NO_CONNECTION, HttpState.NO_CONNECTION.toString()))
        } else if (response.code != HttpURLConnection.HTTP_OK) {
            val message = response.message
            when (response.code) {
                HttpURLConnection.HTTP_NOT_FOUND -> httpEvent.onNext(
                    Pair(HttpState.NOT_FOUND, message)
                )
                HttpURLConnection.HTTP_INTERNAL_ERROR -> httpEvent.onNext(
                    Pair(HttpState.SERVER_ERROR, message)
                )
                HttpURLConnection.HTTP_BAD_GATEWAY -> httpEvent.onNext(
                    Pair(HttpState.SERVER_ERROR, message)
                )
                HttpURLConnection.HTTP_UNAVAILABLE -> httpEvent.onNext(
                    Pair(HttpState.SERVER_ERROR, message)
                )
                HttpURLConnection.HTTP_UNAUTHORIZED -> httpEvent.onNext(
                    Pair(HttpState.UNAUTHORIZED, message)
                )
                HttpURLConnection.HTTP_FORBIDDEN -> httpEvent.onNext(
                    Pair(HttpState.UNAUTHORIZED, message)
                ) /* check if still need to logout */
                HttpURLConnection.HTTP_NOT_ACCEPTABLE -> httpEvent.onNext(
                    Pair(HttpState.UNAUTHORIZED, message)
                )
                else -> httpEvent.onNext(
                    Pair(HttpState.UNKNOWN_ERROR, HttpState.UNKNOWN_ERROR.toString())
                )
            }
        } else {
            try {
                /* don't use response.body.string() */
                val sBody: String = response.peekBody(Long.MAX_VALUE).string()
                val oJson = JSONObject(sBody)
                val code: String = oJson.optString("errorCode")
                val message: String = oJson.optString("message")
                if (code == ErrorCode.INVALID_AUTH_TOKEN) {
                    httpEvent.onNext(Pair(HttpState.UNAUTHORIZED, message))
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return response
    }

}