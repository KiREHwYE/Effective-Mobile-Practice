package com.kire.network.api

import com.kire.network.dto.response.MockResponse

/**
 * Интерфейс сервиса для работы с API
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
internal interface IApiService {
    suspend fun getMockData(): MockResponse
}