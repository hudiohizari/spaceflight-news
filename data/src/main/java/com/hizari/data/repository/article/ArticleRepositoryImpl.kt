package com.hizari.data.repository.article

import com.hizari.common.data.Resource
import com.hizari.data.mapper.article.ArticleMapper
import com.hizari.data.network.service.ArticleService
import com.hizari.data.network.util.SafeApiRequest
import com.hizari.domain.model.article.Article
import com.hizari.domain.repository.article.ArticleRepository

/**
 * Spaceflight News - com.hizari.data.repository.article
 *
 * Created by hudiohizari on 24/10/24.
 * https://github.com/hudiohizari
 *
 */
class ArticleRepositoryImpl(
    private val mapper: ArticleMapper,
    private val service: ArticleService,
) : ArticleRepository, SafeApiRequest() {
    override suspend fun getArticleList(
        newsSite: String?,
        limit: Int,
        offset: Int,
        search: String?
    ): Resource<List<Article>> {
        return handleResource(
            resourceCall = {
                apiRequest {
                    service.getArticleList(
                        newsSite = newsSite,
                        limit = limit,
                        offset = offset,
                        search = search
                    )
                }
            },
            onSuccess = {
                val mappedList = it.results?.map { dto ->
                    mapper.map(dto)
                }.orEmpty()
                Resource.Success(mappedList)
            }
        )
    }

    override suspend fun getArticleById(id: String): Resource<Article> {
        return handleResource(
            resourceCall = {
                apiRequest {
                    service.getArticleById(id)
                }
            },
            onSuccess = {
                Resource.Success(mapper.map(it))
            }
        )
    }

}