package com.kire.jobs.presentation.mapper.vacancy

import com.kire.jobs.data.mapper.vacancy.toDomain
import com.kire.jobs.domain.model.vacancy.VacancyDomain
import com.kire.jobs.presentation.model.vacancy.Vacancy
import com.kire.network.dto.response.vacancy.VacancyResponse

/**
 * Конвертирует VacancyResponse в VacancyDomain
 *
 * @see VacancyResponse
 * @see VacancyDomain
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
fun VacancyDomain.toPresentation() = Vacancy(
    id = this.id,
    lookingNumber = this.lookingNumber,
    title = this.title,
    address = this.address.toPresentation(),
    company = this.company,
    experience = this.experience.toPresentation(),
    publishedDate = this.publishedDate,
    isFavorite = this.isFavorite,
    salary = this.salary.toPresentation(),
    schedules = this.schedules,
    appliedNumber = this.appliedNumber,
    description = this.description,
    responsibilities = this.responsibilities,
    questions = this.questions
)