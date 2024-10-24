package com.hizari.data.network.service

import com.hizari.common.util.Constant
import com.hizari.data.model.base.BasePaginationResponse
import com.hizari.data.model.dto.report.ReportDTO
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
interface ReportService {
    @GET("v4/reports")
    suspend fun getReportList(
        @Query("news_site") newsSite: String? = null,
        @Query("limit") limit: Int? = 10,
        @Query("offset") offset: Int? = 10,
        @Query("search") search: String? = null
    ): Response<BasePaginationResponse<ReportDTO>>

    @GET("v4/reports/{id}")
    suspend fun getReportById(@Path("id") id: String): Response<ReportDTO>

    companion object {
        operator fun invoke(client: Client): ReportService {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constant.URL.BASE_URL)
                .client(client.provideClient())
                .build()
                .create(ReportService::class.java)
        }
    }
}