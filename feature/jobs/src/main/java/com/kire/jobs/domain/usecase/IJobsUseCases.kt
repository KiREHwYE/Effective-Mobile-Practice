package com.kire.jobs.domain.usecase

/**
 * Usecase'ы для получения вакансий и предложений
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
sealed interface IJobsUseCases {
    val getVacanciesUseCase: GetVacanciesUseCase
    val getOffersUseCase: GetOffersUseCase
}