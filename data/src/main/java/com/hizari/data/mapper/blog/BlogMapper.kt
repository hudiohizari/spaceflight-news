package com.hizari.data.mapper.blog

import com.hizari.common.extention.orZero
import com.hizari.data.model.dto.blog.BlogDTO
import com.hizari.domain.model.blog.Blog

/**
 * Spaceflight News - com.hizari.data.mapper.blog
 *
 * Created by hudiohizari on 24/10/24.
 * https://github.com/hudiohizari
 *
 */
class BlogMapper {
    fun map(dto: BlogDTO): Blog {
        return Blog(
            id = dto.id.orZero(),
            title = dto.title.orEmpty(),
            imageUrl = dto.imageUrl.orEmpty()
        )
    }
}