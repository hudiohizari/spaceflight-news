package com.hizari.data.network.util

import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.hizari.data.network.interceptor.AccessTokenInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

/**
 * Spaceflight News - com.hizari.data.network.util
 *
 * Created by hudiohizari on 24/10/24.
 * https://github.com/hudiohizari
 *
 */

class Client(
    private val chuckerInterceptor: ChuckerInterceptor,
    private val accessTokenInterceptor: AccessTokenInterceptor,
) {

    fun provideClient(): OkHttpClient {
        val interceptorLogging = HttpLoggingInterceptor()
        interceptorLogging.setLevel(HttpLoggingInterceptor.Level.BODY)

        return OkHttpClient.Builder()
            .addInterceptor(interceptorLogging)
            .addInterceptor(chuckerInterceptor)
            .addInterceptor(accessTokenInterceptor)
            .connectTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .build()
    }

}