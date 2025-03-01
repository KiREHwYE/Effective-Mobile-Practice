package com.kire.jobs.presentation.model.vacancy

/**
 * Содержит информацию о времени занятости
 * в рамках предлагаемой работы
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
data class Schedules(
    val schedules: List<String> = emptyList()
)