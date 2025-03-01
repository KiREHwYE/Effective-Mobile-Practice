package com.kire.jobs.data.mapper.vacancy

import com.kire.network.dto.response.vacancy.VacancyResponse
import com.kire.jobs.domain.model.vacancy.VacancyDomain
import com.kire.network.dto.response.vacancy.AddressResponse
import com.kire.network.dto.response.vacancy.ExperienceResponse
import com.kire.network.dto.response.vacancy.SalaryResponse

/**
 * Конвертирует VacancyResponse в VacancyDomain
 *
 * @see VacancyResponse
 * @see VacancyDomain
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
fun VacancyResponse.toDomain() = VacancyDomain(
    id = this.id,
    lookingNumber = this.lookingNumber,
    title = this.title,
    address = this.address.toDomain(),
    company = this.company,
    experience = this.experience.toDomain(),
    publishedDate = this.publishedDate,
    isFavorite = this.isFavorite,
    salary = this.salary.toDomain(),
    schedules = this.schedules,
    appliedNumber = this.appliedNumber,
    description = this.description,
    responsibilities = this.responsibilities,
    questions = this.questions
)