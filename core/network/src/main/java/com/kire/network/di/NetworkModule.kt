package com.kire.network.di

import com.kire.network.ErrorsResponse
import com.kire.network.api.ApiService
import com.kire.network.api.IApiService

import kotlinx.serialization.json.Json

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.ServerResponseException
import io.ktor.serialization.JsonConvertException

import dagger.Module
import dagger.Provides


/**
 *  Предоставляет зависимости, связанные с сетевым взаимодействием приложения
 *
 *  @author Михаил Гонтарев (KiREHwYE)
 */
@Module
object NetworkModule {

    /**
     *  Создает HttpClient
     *
     *  @author Михаил Гонтарев (KiREHwYE)
     */
    @Provides
    fun provideHttpClient(): HttpClient {

        return HttpClient(OkHttp) {
            expectSuccess = true

            install(ContentNegotiation) {
                json(
                    Json {
                        prettyPrint = true
                        isLenient = true
                        ignoreUnknownKeys = true
                    }
                )
            }

            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        println("HTTP call: $message")
                    }
                }
                level = LogLevel.ALL
            }

            HttpResponseValidator {
                handleResponseExceptionWithRequest { exception, _ ->
                    val response = when(exception) {
                        is ClientRequestException -> {
                            val exceptionResponse = exception.response
                            try {
                                exceptionResponse.body<ErrorsResponse>()
                            } catch (e: JsonConvertException) {
                                val body = exceptionResponse.body<String>()
                                ErrorsResponse(errors = listOf(body))
                            }
                        }
                        is ServerResponseException -> {
                            val exceptionResponse = exception.response
                            try {
                                exceptionResponse.body<ErrorsResponse>()
                            } catch (e: JsonConvertException) {
                                val body = exceptionResponse.body<String>()
                                ErrorsResponse(errors = listOf(body))
                            }
                        }

                        else -> {
                            ErrorsResponse()
                        }
                    }

                    if (response.errors.isNotEmpty())
                        throw response
                }
            }
        }
    }

    /**
     * Создает ApiService
     *
     * @return ApiService - для работы с API
     *
     * @author Михаил Гонтарев (KiREHwYE)
     */
    @Provides
    fun provideApiService(client: HttpClient): IApiService {
        return ApiService(client)
    }
}