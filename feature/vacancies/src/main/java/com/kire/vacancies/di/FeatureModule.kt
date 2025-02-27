package com.kire.vacancies.di

import com.kire.network.api.IApiService
import com.kire.vacancies.data.JobsRepository
import com.kire.vacancies.domain.IJobsRepository

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher

/**
 * Отвечает за инжекцию зависимостей в рамках feature:vacancies
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Module
class FeatureModule {

    /**
     * Отвечает за создание JobsRepository
     *
     * @param apiService для работы с API
     * @param coroutineDispatcher поток выполнения корутины
     *
     * @see IJobsRepository
     *
     * @author Михаил Гонтарев (KiREHwYE)
     */
    @Provides
    fun provideJobsRepository(apiService: IApiService, coroutineDispatcher: CoroutineDispatcher): IJobsRepository {
        return JobsRepository(apiService, coroutineDispatcher)
    }
}