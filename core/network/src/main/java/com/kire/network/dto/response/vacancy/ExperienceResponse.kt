package com.kire.network.dto.response.vacancy

import kotlinx.serialization.Serializable

/**
 * Содержит информацию о необходимом опыте работы
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Serializable
data class ExperienceResponse(
    val previewText: String? = null,
    val text: String? = null
)
