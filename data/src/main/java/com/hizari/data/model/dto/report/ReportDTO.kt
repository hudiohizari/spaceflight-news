package com.hizari.data.model.dto.report

import com.google.gson.annotations.SerializedName

data class ReportDTO(
    val id: Int? = null,
    @SerializedName("image_url")
    val imageUrl: String? = null,
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