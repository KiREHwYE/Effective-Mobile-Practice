package com.kire.vacancies.domain.model.vacancy

/**
 * Содержит информацию о времени занятости
 * в рамках предлагаемой работы
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
data class SchedulesDomain(
    val schedules: List<String> = emptyList()
)