package com.hizari.data.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Spaceflight News - com.hizari.data.network.interceptor
 *
 * Created by hudiohizari on 24/10/24.
 * https://github.com/hudiohizari
 *
 */
class AccessTokenInterceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val tokenResult = "mock_token"

        val newRequest = request.newBuilder()
            .addHeader("Authorization", "Bearer $tokenResult")
            .build()

        return chain.proceed(newRequest)
    }
}