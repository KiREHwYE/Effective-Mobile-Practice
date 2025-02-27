package com.kire.vacancies.domain.usecase

import javax.inject.Inject

/**
 * Usecase'ы для получения вакансий и предложений
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
data class JobsUseCases @Inject constructor(
    override val getVacanciesUseCase: GetVacanciesUseCase,
    override val getOffersUseCase: GetOffersUseCase
): IJobsUseCases