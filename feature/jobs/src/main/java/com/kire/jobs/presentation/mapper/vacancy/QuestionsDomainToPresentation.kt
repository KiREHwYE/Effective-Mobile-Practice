package com.kire.jobs.presentation.mapper.vacancy

import com.kire.jobs.domain.model.vacancy.QuestionsDomain
import com.kire.jobs.presentation.model.vacancy.Questions

/**
 * Конвертирует QuestionsDomain в Questions
 *
 * @see Questions
 * @see QuestionsDomain
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
fun QuestionsDomain.toPresentation() = Questions(
    questions = this.questions
)