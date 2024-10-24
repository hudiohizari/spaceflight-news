package com.hizari.domain.di

import com.hizari.domain.repository.article.ArticleRepository
import com.hizari.domain.usecase.article.GetArticleListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Spaceflight News - com.hizari.domain.di
 *
 * Created by hudiohizari on 24/10/24.
 * https://github.com/hudiohizari
 *
 */

@Module
@InstallIn(SingletonComponent::class)
object ArticleModule {

    @Provides
    @Singleton
    fun provideGetArticleListUseCase(
        articleRepository: ArticleRepository,
    ): GetArticleListUseCase {
        return GetArticleListUseCase(repository = articleRepository)
    }

}