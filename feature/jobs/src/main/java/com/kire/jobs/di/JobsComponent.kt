package com.kire.jobs.di

import com.kire.di.CoroutineModule
import com.kire.network.di.NetworkModule
import com.kire.jobs.domain.IJobsRepository
import com.kire.jobs.domain.usecase.IJobsUseCases
import com.kire.jobs.presentation.JobsViewModelFactory
import com.kire.network.di.NetworkComponent

import dagger.Component

import javax.inject.Singleton

/**
 * Компонент Dagger для предоставления зависимостей, связанных вакансиями и предложениями.
 *
 * Этот компонент инжектирует зависимости, предоставляемые в модуле [JobsModule]
 *
 * @see NetworkModule Модуль, который предоставляет зависимости для сетевого взаимодействия.
 * @see JobsModule Отвечает за инжекцию зависимостей в рамках feature:vacancies.
 * @see IJobsRepository
 * @see IJobsUseCases
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Singleton
@Component(dependencies = [NetworkComponent::class], modules = [JobsModule::class, CoroutineModule::class])
interface JobsComponent {
    fun provideJobsRepository(): IJobsRepository
    fun provideJobsUseCases(): IJobsUseCases
    fun provideJobsViewModelFactory(): JobsViewModelFactory
}
