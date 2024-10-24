package com.hizari.data.mapper.article

import com.hizari.common.extention.orZero
import com.hizari.data.model.dto.article.ArticleDTO
import com.hizari.domain.model.article.Article

/**
 * Spaceflight News - com.hizari.data.mapper.article
 *
 * Created by hudiohizari on 24/10/24.
 * https://github.com/hudiohizari
 *
 */

class ArticleMapper {
    fun map(dto: ArticleDTO): Article {
        return Article(
            id = dto.id.orZero(),
            title = dto.title.orEmpty(),
            imageUrl = dto.imageUrl.orEmpty()
        )
    }
}