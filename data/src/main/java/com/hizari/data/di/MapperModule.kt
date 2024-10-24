package com.hizari.data.di

import com.hizari.data.mapper.article.ArticleMapper
import com.hizari.data.mapper.blog.BlogMapper
import com.hizari.data.mapper.report.ReportMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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
object MapperModule {

    @Provides
    @Singleton
    fun provideArticleMapper(): ArticleMapper {
        return ArticleMapper()
    }


    @Provides
    @Singleton
    fun provideBlogMapper(): BlogMapper {
        return BlogMapper()
    }


    @Provides
    @Singleton
    fun provideReportMapper(): ReportMapper {
        return ReportMapper()
    }

}