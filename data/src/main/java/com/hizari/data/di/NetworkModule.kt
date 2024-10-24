package com.hizari.data.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.hizari.data.network.interceptor.AccessTokenInterceptor
import com.hizari.data.network.service.ArticleService
import com.hizari.data.network.service.BlogService
import com.hizari.data.network.service.ReportService
import com.hizari.data.network.util.Client
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Spaceflight News - com.hizari.data.di
 *
 * Created by hudiohizari on 24/10/24.
 * https://github.com/hudiohizari
 *
 */

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideChuckerInterceptor(
        @ApplicationContext
        context: Context
    ): ChuckerInterceptor {
        return ChuckerInterceptor.Builder(context = context).build()
    }

    @Provides
    @Singleton
    fun provideAccessTokenInterceptor(): AccessTokenInterceptor {
        return AccessTokenInterceptor()
    }

    @Provides
    @Singleton
    fun provideClient(
        chuckerInterceptor: ChuckerInterceptor,
        accessTokenInterceptor: AccessTokenInterceptor,
    ): Client {
        return Client(
            chuckerInterceptor = chuckerInterceptor,
            accessTokenInterceptor = accessTokenInterceptor,
        )
    }

    @Provides
    @Singleton
    fun provideArticleService(client: Client): ArticleService {
        return ArticleService.invoke(client = client)
    }

    @Provides
    @Singleton
    fun provideBlogService(client: Client): BlogService {
        return BlogService.invoke(client = client)
    }

    @Provides
    @Singleton
    fun provideReportService(client: Client): ReportService {
        return ReportService.invoke(client = client)
    }

}