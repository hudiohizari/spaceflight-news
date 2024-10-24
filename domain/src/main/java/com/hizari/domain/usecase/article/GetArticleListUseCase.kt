package com.hizari.domain.usecase.article

import com.hizari.common.data.Resource
import com.hizari.domain.model.article.Article
import com.hizari.domain.repository.article.ArticleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Spaceflight News - com.hizari.domain.usecase.article
 *
 * Created by hudiohizari on 24/10/24.
 * https://github.com/hudiohizari
 *
 */

class GetArticleListUseCase(private val repository: ArticleRepository) {

    operator fun invoke(
        newsSite: String? = null,
        limit: Int = 10,
        offset: Int = 10,
        search: String? = null,
    ): Flow<Resource<List<Article>>> = flow {
        emit(Resource.Loading)
        emit(
            repository.getArticleList(
                newsSite = newsSite,
                limit = limit,
                offset = offset,
                search = search
            )
        )
    }
}