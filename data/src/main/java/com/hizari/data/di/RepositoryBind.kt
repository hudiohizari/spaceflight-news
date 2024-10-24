package com.hizari.data.di

import com.hizari.data.repository.article.ArticleRepositoryImpl
import com.hizari.data.repository.blog.BlogRepositoryImpl
import com.hizari.data.repository.report.ReportRepositoryImpl
import com.hizari.domain.repository.article.ArticleRepository
import com.hizari.domain.repository.blog.BlogRepository
import com.hizari.domain.repository.report.ReportRepository
import dagger.Binds
import dagger.Module
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
abstract class RepositoryBind {

    @Binds
    @Singleton
    abstract fun bindArticleRepository(
        articleRepositoryImpl: ArticleRepositoryImpl
    ): ArticleRepository

    @Binds
    @Singleton
    abstract fun bindBlogRepository(
        blogRepositoryImpl: BlogRepositoryImpl
    ): BlogRepository

    @Binds
    @Singleton
    abstract fun bindReportRepository(
        reportRepositoryImpl: ReportRepositoryImpl
    ): ReportRepository
}