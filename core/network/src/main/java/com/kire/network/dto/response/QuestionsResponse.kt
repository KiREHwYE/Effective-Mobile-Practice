package com.kire.network.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class QuestionsResponse(
    val questions: List<String> = emptyList()
)
