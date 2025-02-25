package com.kire.network.dto.response.vacancy

import kotlinx.serialization.Serializable

@Serializable
data class ExperienceResponse(
    val previewText: String? = null,
    val text: String? = null
)
