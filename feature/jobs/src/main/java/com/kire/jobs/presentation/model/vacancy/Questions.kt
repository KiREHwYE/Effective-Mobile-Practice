package com.kire.jobs.presentation.model.vacancy

/**
 * Содержит вопросы, которые может задать пользователь
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
data class Questions(
    val questions: List<String> = emptyList()
)