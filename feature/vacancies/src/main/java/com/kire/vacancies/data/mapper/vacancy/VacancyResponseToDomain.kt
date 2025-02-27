package com.kire.vacancies.data.mapper.vacancy

import com.kire.network.dto.response.vacancy.VacancyResponse
import com.kire.vacancies.domain.model.vacancy.VacancyDomain

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
    title = this.title,
    address = this.address.toDomain(),
    company = this.company,
    experience = this.experience.toDomain(),
    publishedDate = this.publishedDate,
    isFavorite = this.isFavorite,
    salary = this.salary.toDomain(),
    schedules = this.schedules.toDomain(),
    appliedNumber = this.appliedNumber,
    description = this.description,
    responsibilities = this.responsibilities,
    questions = this.questions.toDomain()
)