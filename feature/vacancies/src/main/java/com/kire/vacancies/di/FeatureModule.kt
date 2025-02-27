package com.kire.vacancies.di

import com.kire.network.api.IApiService
import com.kire.vacancies.data.JobsRepository
import com.kire.vacancies.domain.IJobsRepository
import com.kire.vacancies.domain.usecase.GetOffersUseCase
import com.kire.vacancies.domain.usecase.GetVacanciesUseCase
import com.kire.vacancies.domain.usecase.IJobsUseCases
import com.kire.vacancies.domain.usecase.JobsUseCases

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
     * @return IJobsRepository
     *
     * @author Михаил Гонтарев (KiREHwYE)
     */
    @Provides
    fun provideJobsRepository(apiService: IApiService, coroutineDispatcher: CoroutineDispatcher): IJobsRepository {
        return JobsRepository(apiService, coroutineDispatcher)
    }

    /**
     * Отвечает за создание JobsUseCases
     *
     * @param getVacanciesUseCase usecase для получения списка вакансий
     * @param getOffersUseCase usecase для получения списка предложений
     *
     * @see GetVacanciesUseCase
     * @see GetOffersUseCase
     * @see IJobsUseCases
     *
     * @return IJobsUseCases
     *
     * @author Михаил Гонтарев (KiREHwYE)
     */
    @Provides
    fun provideJobsUseCases(
        getVacanciesUseCase: GetVacanciesUseCase,
        getOffersUseCase: GetOffersUseCase
    ): IJobsUseCases {
        return JobsUseCases(getVacanciesUseCase, getOffersUseCase)
    }

    /**
     * Отвечает за создание GetVacanciesUseCase
     *
     * @param jobsRepository репозиторий для работы с предложениями для пользователя и вакансиями
     *
     * @see GetVacanciesUseCase
     * @see IJobsRepository
     *
     * @return GetVacanciesUseCase
     *
     * @author Михаил Гонтарев (KiREHwYE)
     */
    @Provides
    fun provideGetVacanciesUseCase(jobsRepository: IJobsRepository): GetVacanciesUseCase {
        return GetVacanciesUseCase(jobsRepository)
    }

    /**
     * Отвечает за создание GetOffersUseCase
     *
     * @param jobsRepository репозиторий для работы с предложениями для пользователя и вакансиями
     *
     * @see IJobsRepository
     * @see GetOffersUseCase
     *
     * @author Михаил Гонтарев (KiREHwYE)
     */
    @Provides
    fun provideGetOffersUseCase(jobsRepository: IJobsRepository): GetOffersUseCase {
        return GetOffersUseCase(jobsRepository)
    }
}