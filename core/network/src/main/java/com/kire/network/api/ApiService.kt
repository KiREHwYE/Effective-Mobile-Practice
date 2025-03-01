package com.kire.network.api

import com.kire.network.HttpRoutes
import com.kire.network.dto.response.MockResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.accept
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.http.contentType
import io.ktor.http.path
import kotlinx.serialization.json.Json
import javax.inject.Inject

/**
 * Сервис для работы с API
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
class ApiService @Inject constructor(
    private val client: HttpClient
): IApiService {


//    override suspend fun getMockData(): MockResponse {
//        return client.get {
//            url {
//                protocol = URLProtocol.HTTPS
//                host = HttpRoutes.HOST
//                path(*HttpRoutes.MOCK_URL.toTypedArray())
//                HttpRoutes.MOCK_URL_PARAMS.forEach { urlParameter ->
//                    parameters.append(name = urlParameter.name, value = urlParameter.value)
//                }
//            }
//            contentType(ContentType.Application.Json)
//        }.body<MockResponse>()
//    }


    /**
     * Получает mock.json с сервера
     *
     * @return MockResponse
     *
     * @author Михаил Гонтарев (KiREHwYE)
     * */
    override suspend fun getMockData(): MockResponse {
        val response: HttpResponse = client.get {
            url {
                protocol = URLProtocol.HTTPS
                host = HttpRoutes.HOST
                path(*HttpRoutes.MOCK_URL.toTypedArray())
                HttpRoutes.MOCK_URL_PARAMS.forEach { urlParameter ->
                    parameters.append(name = urlParameter.name, value = urlParameter.value)
                }
            }
            accept(ContentType.Application.Json)
        }

        /*
            Из-за того, что с сервера приходит ContentType: application/octet-stream вместо application/json,
            пришлось колхозить.

            А так, версия выше бы работала как надо
         */
        return if (response.contentType() == ContentType.Application.OctetStream) {
            val text = response.body<String>()  // Read as raw string
            Json.decodeFromString(MockResponse.serializer(), text)
        } else {
            response.body<MockResponse>()
        }
    }
}