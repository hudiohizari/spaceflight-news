package com.hizari.data.model.dto.article

import com.google.gson.annotations.SerializedName
import com.hizari.data.model.dto.event.EventDTO
import com.hizari.data.model.dto.launch.LaunchDTO

/**
 * Spaceflight News - com.hizari.data.model.dto.article
 *
 * Created by hudiohizari on 24/10/24.
 * https://github.com/hudiohizari
 *
 */

data class ArticleDTO(
    val events: List<EventDTO>? = null,
    val featured: Boolean? = null,
    val id: Int? = null,
    @SerializedName("image_url")
    val imageUrl: String? = null,
    val launches: List<LaunchDTO>? = null,
    @SerializedName("news_site")
    val newsSite: String? = null,
    @SerializedName("published_at")
    val publishedAt: String? = null,
    val summary: String? = null,
    val title: String? = null,
    @SerializedName("updated_at")
    val updatedAt: String? = null,
    val url: String? = null
)
