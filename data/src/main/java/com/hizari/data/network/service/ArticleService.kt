package com.hizari.data.network.service

import com.hizari.common.util.Constant
import com.hizari.data.model.base.BasePaginationResponse
import com.hizari.data.model.dto.article.ArticleDTO
import com.hizari.data.network.util.Client
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Spaceflight News - com.hizari.data.network.service
 *
 * Created by hudiohizari on 24/10/24.
 * https://github.com/hudiohizari
 *
 */
interface ArticleService {
    @GET("v4/articles")
    suspend fun getArticleList(
        @Query("news_site") newsSite: String? = null,
        @Query("limit") limit: Int? = 10,
        @Query("offset") offset: Int? = 10,
        @Query("search") search: String? = null
    ): Response<BasePaginationResponse<ArticleDTO>>

    @GET("v4/articles/{id}")
    suspend fun getArticleById(@Path("id") id: String): Response<ArticleDTO>

    companion object {
        operator fun invoke(client: Client): ArticleService {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constant.URL.BASE_URL)
                .client(client.provideClient())
                .build()
                .create(ArticleService::class.java)
        }
    }
}