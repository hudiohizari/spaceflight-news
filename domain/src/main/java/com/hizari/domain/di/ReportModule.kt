package com.hizari.domain.di

import com.hizari.domain.repository.report.ReportRepository
import com.hizari.domain.usecase.report.GetReportListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Spaceflight News - com.hizari.domain.di
 *
 * Created by hudiohizari on 24/10/24.
 * https://github.com/hudiohizari
 *
 */

@Module
@InstallIn(SingletonComponent::class)
object ReportModule {

    @Provides
    @Singleton
    fun provideGetReportListUseCase(
        reportRepository: ReportRepository,
    ): GetReportListUseCase {
        return GetReportListUseCase(repository = reportRepository)
    }

}