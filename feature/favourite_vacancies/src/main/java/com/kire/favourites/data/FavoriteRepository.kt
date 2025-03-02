package com.kire.favourites.data

import com.kire.favourites.data.mapper.vacancy.toDomain
import com.kire.favourites.domain.IFavoriteRepository
import com.kire.favourites.domain.model.IRequestResultDomain
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
class FavoriteRepository @Inject constructor(
    private val apiService: IApiService,
    @IODispatcher private val coroutineDispatcher: CoroutineDispatcher
): IFavoriteRepository {

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
    override suspend fun getFavoriteVacancies(): IRequestResultDomain =
        makeRequest {
            apiService.getMockData().vacancies.toDomain()
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
