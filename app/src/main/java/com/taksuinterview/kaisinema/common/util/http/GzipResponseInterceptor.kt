package com.taksuinterview.kaisinema.common.util.http

import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.internal.http.RealResponseBody
import okio.GzipSource
import okio.buffer
import java.io.IOException

internal class GzipResponseInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())
        return unzip(response)
    }

    private fun unzip(response: Response): Response {
        if (response.body == null) {
            return response
        }
        val contentEncoding = response.headers["Content-Encoding"]
        //check if we have gzip response
        return if (contentEncoding != null && contentEncoding == "gzip") {
            val contentType = response.body!!.contentType()
            val sContentType = contentType.toString()
            val contentLength = response.body!!.contentLength()
            val responseBody = GzipSource(response.body!!.source())
            val strippedHeaders = response.headers.newBuilder().build()
            response.newBuilder().headers(strippedHeaders)
                .body(RealResponseBody(sContentType, contentLength, responseBody.buffer()))
                .build()
        } else {
            response
        }
    }
}