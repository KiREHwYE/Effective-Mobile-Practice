package com.kire.jobs.data.mapper.vacancy

import com.kire.network.dto.response.vacancy.QuestionsResponse
import com.kire.jobs.domain.model.vacancy.QuestionsDomain

/**
 * Конвертирует QuestionsResponse в QuestionsDomain
 *
 * @see QuestionsResponse
 * @see QuestionsDomain
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
fun QuestionsResponse.toDomain() = QuestionsDomain(
    questions = this.questions
)