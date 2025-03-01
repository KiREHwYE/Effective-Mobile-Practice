package com.kire.jobs.di

import com.kire.network.api.IApiService
import com.kire.jobs.data.JobsRepository
import com.kire.jobs.domain.IJobsRepository
import com.kire.jobs.domain.usecase.GetOffersUseCase
import com.kire.jobs.domain.usecase.GetVacanciesUseCase
import com.kire.jobs.domain.usecase.IJobsUseCases
import com.kire.jobs.domain.usecase.JobsUseCases
import com.kire.jobs.presentation.JobsViewModelFactory
import com.kire.util.IODispatcher

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher

/**
 * Отвечает за инжекцию зависимостей в рамках feature:vacancies
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Module
class JobsModule {

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
    fun provideJobsRepository(
        apiService: IApiService,
        @IODispatcher coroutineDispatcher: CoroutineDispatcher
    ): IJobsRepository {
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

    /**
     * Отвечает за создание provideJobsViewModelFactory
     *
     * @param jobsUseCases usecase'ы экранов feature:jobs
     *
     * @see IJobsUseCases
     * @see JobsViewModelFactory
     *
     * @author Михаил Гонтарев (KiREHwYE)
     */
    @Provides
    fun provideJobsViewModelFactory(jobsUseCases: IJobsUseCases): JobsViewModelFactory {
        return JobsViewModelFactory(jobsUseCases)
    }
}