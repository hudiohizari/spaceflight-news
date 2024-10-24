package com.hizari.data.repository.report

import com.hizari.common.data.Resource
import com.hizari.data.mapper.report.ReportMapper
import com.hizari.data.network.service.ReportService
import com.hizari.data.network.util.SafeApiRequest
import com.hizari.domain.model.report.Report
import com.hizari.domain.repository.report.ReportRepository

/**
 * Spaceflight News - com.hizari.data.repository.blog
 *
 * Created by hudiohizari on 24/10/24.
 * https://github.com/hudiohizari
 *
 */
class ReportRepositoryImpl(
    private val mapper: ReportMapper,
    private val service: ReportService,
) : ReportRepository, SafeApiRequest() {
    override suspend fun getReportList(
        newsSite: String?,
        limit: Int,
        offset: Int,
        search: String?
    ): Resource<List<Report>> {
        return handleResource(
            resourceCall = {
                apiRequest {
                    service.getReportList(
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

    override suspend fun getReportById(id: String): Resource<Report> {
        return handleResource(
            resourceCall = {
                apiRequest {
                    service.getReportById(id)
                }
            },
            onSuccess = {
                Resource.Success(mapper.map(it))
            }
        )
    }

}