package com.kire.vacancies.di

import com.kire.network.api.IApiService
import com.kire.vacancies.data.JobsRepository
import com.kire.vacancies.domain.IJobsRepository

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher

/**
 * Отвечает за инжекцию зависимостей в рамках feature:vacancies
 */
@Module
class FeatureModule {
    @Provides
    fun provideJobsRepository(apiService: IApiService, coroutineDispatcher: CoroutineDispatcher): IJobsRepository {
        return JobsRepository(apiService, coroutineDispatcher)
    }
}