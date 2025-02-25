package com.kire.network.api

import com.kire.network.dto.response.MockResponse

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.http.contentType
import io.ktor.http.path

import javax.inject.Inject

/**
 * Сервис для работы с API
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
internal class ApiService @Inject constructor(
    private val client: HttpClient
): IApiService {

    /**
     * Получает mock.json с сервера
     *
     * @return MockResponse
     *
     * @author Михаил Гонтарев (KiREHwYE)
     * */
    override suspend fun getMockData(): MockResponse {
        return client.get {
            url {
                protocol = URLProtocol.HTTPS
                host = "drive.usercontent.google.com"
                path("u", "0", "uc")
                parameters.append("id", "1z4TbeDkbfXkvgpoJprXbN85uCcD7f00r")
                parameters.append("export", "download")
            }
            contentType(ContentType.Application.Json)
        }.body<MockResponse>()
    }
}