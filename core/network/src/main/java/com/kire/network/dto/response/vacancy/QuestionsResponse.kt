package com.kire.network.dto.response.vacancy

import kotlinx.serialization.Serializable

@Serializable
data class QuestionsResponse(
    val questions: List<String> = emptyList()
)
