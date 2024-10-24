package com.hizari.domain.usecase.blog

import com.hizari.common.data.Resource
import com.hizari.domain.model.blog.Blog
import com.hizari.domain.repository.blog.BlogRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Spaceflight News - com.hizari.domain.usecase.blog
 *
 * Created by hudiohizari on 24/10/24.
 * https://github.com/hudiohizari
 *
 */
class GetBlogListUseCase(private val repository: BlogRepository) {

    operator fun invoke(
        newsSite: String? = null,
        limit: Int = 10,
        offset: Int = 10,
        search: String? = null,
    ): Flow<Resource<List<Blog>>> = flow {
        emit(Resource.Loading)
        emit(
            repository.getBlogList(
                newsSite = newsSite,
                limit = limit,
                offset = offset,
                search = search
            )
        )
    }
}