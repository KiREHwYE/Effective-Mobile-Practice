package com.kire.vacancies.domain.model.vacancy

/**
 * Содержит вопросы, которые может задать пользователь
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
data class QuestionsDomain(
    val questions: List<String> = emptyList()
)