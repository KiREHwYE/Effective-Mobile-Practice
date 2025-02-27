package com.kire.vacancies.data.mapper.vacancy

import com.kire.network.dto.response.vacancy.ExperienceResponse
import com.kire.vacancies.domain.model.vacancy.ExperienceDomain

/**
 * Конвертирует ExperienceResponse в ExperienceDomain
 *
 * @see ExperienceResponse
 * @see ExperienceDomain
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
fun ExperienceResponse.toDomain() = ExperienceDomain(
    previewText = this.previewText,
    text = this.text
)