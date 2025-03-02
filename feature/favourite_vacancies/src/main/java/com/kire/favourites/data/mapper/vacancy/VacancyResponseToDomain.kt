package com.kire.favourites.data.mapper.vacancy

import com.kire.favourites.domain.model.vacancy.VacancyDomain
import com.kire.network.dto.response.vacancy.VacancyResponse

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