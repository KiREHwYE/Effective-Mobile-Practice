package com.kire.network.api

import com.kire.network.dto.response.MockResponse

/**
 * Интерфейс сервиса для работы с API
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
interface IApiService {
    suspend fun getMockData(): MockResponse
}