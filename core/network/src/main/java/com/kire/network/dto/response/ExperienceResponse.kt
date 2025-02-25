package com.kire.network.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class ExperienceResponse(
    val previewText: String? = null,
    val text: String? = null
)
