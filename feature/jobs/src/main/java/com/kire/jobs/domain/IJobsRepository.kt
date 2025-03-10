package com.kire.jobs.domain

import com.kire.jobs.domain.model.IRequestResultDomain

/**
 * Репозиторий для работы с предложениями для пользователя и вакансиями
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
interface IJobsRepository {
    suspend fun getVacancies(): IRequestResultDomain
    suspend fun getOffers(): IRequestResultDomain
}