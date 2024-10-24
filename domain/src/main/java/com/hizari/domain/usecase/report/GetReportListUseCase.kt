package com.hizari.domain.usecase.report

import com.hizari.common.data.Resource
import com.hizari.domain.model.report.Report
import com.hizari.domain.repository.report.ReportRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Spaceflight News - com.hizari.domain.usecase.report
 *
 * Created by hudiohizari on 24/10/24.
 * https://github.com/hudiohizari
 *
 */

class GetReportListUseCase(private val repository: ReportRepository) {

    operator fun invoke(
        newsSite: String? = null,
        limit: Int = 10,
        offset: Int = 10,
        search: String? = null,
    ): Flow<Resource<List<Report>>> = flow {
        emit(Resource.Loading)
        emit(
            repository.getReportList(
                newsSite = newsSite,
                limit = limit,
                offset = offset,
                search = search
            )
        )
    }
}