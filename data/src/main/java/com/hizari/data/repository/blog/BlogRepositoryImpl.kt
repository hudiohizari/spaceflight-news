package com.hizari.data.repository.blog

import com.hizari.common.data.Resource
import com.hizari.data.mapper.blog.BlogMapper
import com.hizari.data.network.service.BlogService
import com.hizari.data.network.util.SafeApiRequest
import com.hizari.domain.model.blog.Blog
import com.hizari.domain.repository.blog.BlogRepository
import javax.inject.Inject

/**
 * Spaceflight News - com.hizari.data.repository.blog
 *
 * Created by hudiohizari on 24/10/24.
 * https://github.com/hudiohizari
 *
 */
class BlogRepositoryImpl @Inject constructor(
    private val mapper: BlogMapper,
    private val service: BlogService,
) : BlogRepository, SafeApiRequest() {
    override suspend fun getBlogList(
        newsSite: String?,
        limit: Int,
        offset: Int,
        search: String?
    ): Resource<List<Blog>> {
        return handleResource(
            resourceCall = {
                apiRequest {
                    service.getBlogList(
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

    override suspend fun getBlogById(id: String): Resource<Blog> {
        return handleResource(
            resourceCall = {
                apiRequest {
                    service.getBlogById(id)
                }
            },
            onSuccess = {
                Resource.Success(mapper.map(it))
            }
        )
    }

}