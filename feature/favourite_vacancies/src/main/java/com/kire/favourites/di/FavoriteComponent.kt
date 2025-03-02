package com.kire.favourites.di

import com.kire.di.CoroutineModule
import com.kire.favourites.domain.IFavoriteRepository
import com.kire.favourites.domain.usecase.IFavoriteUseCases
import com.kire.favourites.presentation.viewmodel.FavoriteViewModelFactory
import com.kire.network.di.NetworkModule
import com.kire.network.di.NetworkComponent

import dagger.Component

import javax.inject.Singleton

/**
 * Компонент Dagger для предоставления зависимостей, связанных вакансиями и предложениями.
 *
 * Этот компонент инжектирует зависимости, предоставляемые в модуле FavoriteModule
 *
 * @see NetworkModule Модуль, который предоставляет зависимости для сетевого взаимодействия.
 * @see FavoriteModule Отвечает за инжекцию зависимостей в рамках feature:vacancies.
 * @see IFavoriteRepository
 * @see IFavoriteUseCases
 * @see FavoriteViewModelFactory
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Singleton
@Component(dependencies = [NetworkComponent::class], modules = [FavoriteModule::class, CoroutineModule::class])
interface FavoriteComponent {
    fun provideJobsRepository(): IFavoriteRepository
    fun provideJobsUseCases(): IFavoriteUseCases
    fun provideJobsViewModelFactory(): FavoriteViewModelFactory
}
