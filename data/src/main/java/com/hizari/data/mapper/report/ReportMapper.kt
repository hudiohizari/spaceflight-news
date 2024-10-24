package com.hizari.data.mapper.report

import com.hizari.common.extention.orZero
import com.hizari.data.model.dto.report.ReportDTO
import com.hizari.domain.model.report.Report

/**
 * Spaceflight News - com.hizari.data.mapper.report
 *
 * Created by hudiohizari on 24/10/24.
 * https://github.com/hudiohizari
 *
 */
class ReportMapper {
    fun map(dto: ReportDTO): Report {
        return Report(
            id = dto.id.orZero(),
            title = dto.title.orEmpty(),
            imageUrl = dto.imageUrl.orEmpty()
        )
    }
}