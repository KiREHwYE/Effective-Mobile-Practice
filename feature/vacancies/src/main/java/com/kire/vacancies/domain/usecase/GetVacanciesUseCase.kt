package com.kire.vacancies.domain.usecase

import com.kire.vacancies.domain.IJobsRepository
import javax.inject.Inject

/**
 * Usecase для получения списка вакансий
 *
 * @see IJobsRepository
 * @see IRequestResultDomain
 *
 * @return IRequestResultDomain
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
class GetVacanciesUseCase @Inject constructor(
    private val jobsRepository: IJobsRepository
) {
    suspend operator fun invoke() =
        jobsRepository.getVacancies()
}