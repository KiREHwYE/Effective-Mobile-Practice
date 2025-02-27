package com.kire.vacancies.data

import com.kire.network.api.IApiService
import com.kire.vacancies.domain.IJobsRepository

/**
 * Репозиторий для работы с предложениями для пользователя и вакансиями
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
class JobsRepository @Inject private constructor(
    private val apiService: IApiService
): IJobsRepository {

}