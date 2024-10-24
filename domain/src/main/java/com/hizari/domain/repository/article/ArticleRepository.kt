package com.hizari.domain.repository.article

import com.hizari.common.data.Resource
import com.hizari.domain.model.article.Article

/**
 * Spaceflight News - com.hizari.domain.repository.article
 *
 * Created by hudiohizari on 24/10/24.
 * https://github.com/hudiohizari
 *
 */
interface ArticleRepository {
    suspend fun getArticleList(
        newsSite: String? = null,
        limit: Int = 10,
        offset: Int = 10,
        search: String? = null,
    ): Resource<List<Article>>

    suspend fun getArticleById(id: String): Resource<Article>
}