package com.hizari.domain.repository.report

import com.hizari.common.data.Resource
import com.hizari.domain.model.report.Report

/**
 * Spaceflight News - com.hizari.domain.repository.report
 *
 * Created by hudiohizari on 24/10/24.
 * https://github.com/hudiohizari
 *
 */
interface ReportRepository {
    suspend fun getReportList(
        newsSite: String? = null,
        limit: Int,
        offset: Int,
        search: String? = null,
    ): Resource<List<Report>>

    suspend fun getReportById(id: String): Resource<Report>
}