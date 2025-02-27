package com.kire.vacancies.data.mapper.vacancy

import com.kire.network.dto.response.vacancy.QuestionsResponse
import com.kire.vacancies.domain.model.vacancy.QuestionsDomain

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