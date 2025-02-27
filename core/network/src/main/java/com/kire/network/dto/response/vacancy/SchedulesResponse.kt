package com.kire.network.dto.response.vacancy

import kotlinx.serialization.Serializable

/**
 * Содержит информацию о времени занятости
 * в рамках предлагаемой работы
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Serializable
data class SchedulesResponse(
    val schedules: List<String> = emptyList()
)