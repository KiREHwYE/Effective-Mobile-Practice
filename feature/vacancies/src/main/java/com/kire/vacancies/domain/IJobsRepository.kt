package com.kire.vacancies.domain

import com.kire.vacancies.domain.model.IRequestResultDomain

/**
 * Репозиторий для работы с предложениями для пользователя и вакансиями
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
interface IJobsRepository {
    suspend fun getVacancies(): IRequestResultDomain
    suspend fun getOffers(): IRequestResultDomain
}