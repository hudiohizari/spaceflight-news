package com.hizari.domain.repository.blog

import com.hizari.common.data.Resource
import com.hizari.domain.model.blog.Blog

/**
 * Spaceflight News - com.hizari.domain.repository.blog
 *
 * Created by hudiohizari on 24/10/24.
 * https://github.com/hudiohizari
 *
 */
interface BlogRepository {
    suspend fun getBlogList(
        newsSite: String? = null,
        limit: Int = 10,
        offset: Int = 10,
        search: String? = null,
    ): Resource<List<Blog>>

    suspend fun getBlogById(id: String): Resource<Blog>
}