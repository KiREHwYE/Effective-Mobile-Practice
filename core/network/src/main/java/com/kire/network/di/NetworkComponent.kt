package com.kire.network.di

import androidx.test.espresso.core.internal.deps.dagger.Component

import com.kire.network.api.IApiService

import javax.inject.Singleton

/**
 * Компонент Dagger для предоставления зависимостей, связанных с сетью.
 *
 * Этот компонент инжектирует зависимости, предоставляемые в модуле [NetworkModule],
 * включая создание и предоставление экземпляра [IApiService], который используется для
 * работы с сетевыми запросами.
 *
 * @see NetworkModule Модуль, который предоставляет зависимости для сетевого взаимодействия.
 * @see IApiService Интерфейс, который используется для выполнения сетевых запросов.
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Singleton
@Component(modules = [NetworkModule::class])
internal interface NetworkComponent {
    fun provideApiService(): IApiService
}