package com.kire.jobs.data

import com.kire.jobs.data.mapper.offer.toDomain
import com.kire.jobs.data.mapper.vacancy.toDomain
import com.kire.jobs.domain.IJobsRepository
import com.kire.jobs.domain.model.IRequestResultDomain
import com.kire.network.ErrorsResponse
import com.kire.network.api.IApiService
import com.kire.util.IODispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Репозиторий для работы с предложениями для пользователя и вакансиями
 *
 * @param apiService для работы с API
 * @param coroutineDispatcher поток выполнения корутины
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
class JobsRepository @Inject constructor(
    private val apiService: IApiService,
    @IODispatcher private val coroutineDispatcher: CoroutineDispatcher
): IJobsRepository {

    /**
     * Функция для получения списка доступных вакансий с сервера
     *
     * @see IRequestResultDomain
     * @see IApiService
     *
     * @return IRequestResultDomain
     *
     * @author Михаил Гонтарев (KiREHwYE)
     */
    override suspend fun getVacancies(): IRequestResultDomain =
        makeRequest {
            apiService.getMockData().vacancies.toDomain()
        }

    /**
     * Функция для получения списка доступных вакансий с сервера
     *
     * @see IRequestResultDomain
     * @see IApiService
     *
     * @return IRequestResultDomain
     *
     * @author Михаил Гонтарев (KiREHwYE)
     */
    override suspend fun getOffers(): IRequestResultDomain =
        makeRequest {
            apiService.getMockData().offers.toDomain()
        }

    /**
     * Функция для выполнения suspend запроса к серверу
     *
     * @param func функция, которая будет выполнена в рамках заданного coroutineDispatcher
     *
     * @see IRequestResultDomain
     *
     * @return IRequestResultDomain
     *
     * @author Михаил Гонтарев (KiREHwYE)
     */
    private suspend fun <T> makeRequest(func: suspend () -> T): IRequestResultDomain =
        withContext(coroutineDispatcher) {
            try {
                val response = func()
                IRequestResultDomain.Success(response)
            } catch (e: ErrorsResponse) {
                IRequestResultDomain.Errors(e.errors)
            }
        }
}
