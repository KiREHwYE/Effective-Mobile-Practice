package com.kire.vacancies.data

import com.kire.network.ErrorsResponse
import com.kire.network.api.IApiService
import com.kire.vacancies.domain.IJobsRepository
import com.kire.vacancies.domain.IRequestResultDomain
import javax.inject.Inject

import com.kire.util.IODispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

/**
 * Репозиторий для работы с предложениями для пользователя и вакансиями
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
class JobsRepository @Inject constructor(
    private val apiService: IApiService,
    @IODispatcher private val coroutineDispatcher: CoroutineDispatcher
): IJobsRepository {

    override suspend fun getVacancies(): IRequestResultDomain =
        makeRequest {
            apiService.getMockData().vacancies
        }


    override suspend fun getOffers(): IRequestResultDomain =
        makeRequest {
            apiService.getMockData().offers
        }


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
