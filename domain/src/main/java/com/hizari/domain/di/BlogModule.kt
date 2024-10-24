package com.hizari.domain.di

import com.hizari.domain.repository.blog.BlogRepository
import com.hizari.domain.usecase.blog.GetBlogListUseCase
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
object BlogModule {

    @Provides
    @Singleton
    fun provideGetBlogListUseCase(
        blogRepository: BlogRepository,
    ): GetBlogListUseCase {
        return GetBlogListUseCase(repository = blogRepository)
    }

}