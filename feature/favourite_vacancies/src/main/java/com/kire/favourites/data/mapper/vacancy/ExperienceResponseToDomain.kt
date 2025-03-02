package com.kire.favourites.data.mapper.vacancy

import com.kire.favourites.domain.model.vacancy.ExperienceDomain
import com.kire.network.dto.response.vacancy.ExperienceResponse

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