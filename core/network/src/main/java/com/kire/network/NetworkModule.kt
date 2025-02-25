package com.kire.network

import androidx.test.espresso.core.internal.deps.dagger.Binds
import androidx.test.espresso.core.internal.deps.dagger.Module
import androidx.test.espresso.core.internal.deps.dagger.Provides
import com.kire.network.api.IApiService

import com.kire.network.dto.Errors

import kotlinx.serialization.json.Json

import javax.inject.Singleton

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

/**
 *  Предоставляет зависимости, связанные с сетевым взаимодействием приложения
 */
@Module
internal abstract class NetworkModule {

    @Binds
    @Singleton
    abstract fun provideApiService(apiService: ApiService): IApiService

    @Provides
    @Singleton
    fun provideApiClient(): HttpClient {

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
                                exceptionResponse.body<Errors>()
                            } catch (e: JsonConvertException) {
                                val body = exceptionResponse.body<String>()
                                Errors(errors = listOf(body))
                            }
                        }
                        is ServerResponseException -> {
                            val exceptionResponse = exception.response
                            try {
                                exceptionResponse.body<Errors>()
                            } catch (e: JsonConvertException) {
                                val body = exceptionResponse.body<String>()
                                Errors(errors = listOf(body))
                            }
                        }

                        else -> {
                            Errors()
                        }
                    }

                    if (response.errors.isNotEmpty())
                        throw response
                }
            }
        }
    }
}