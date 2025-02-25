package com.kire.network.dto.response.vacancy

import kotlinx.serialization.Serializable

/**
 * Содержит вопросы, которые может задать пользователь
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Serializable
internal data class QuestionsResponse(
    val questions: List<String> = emptyList()
)
