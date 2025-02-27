package com.kire.vacancies.data.mapper.vacancy

import com.kire.network.dto.response.vacancy.SchedulesResponse
import com.kire.vacancies.domain.model.vacancy.SchedulesDomain

/**
 * Конвертирует SchedulesResponse в SchedulesDomain
 *
 * @see SchedulesResponse
 * @see SchedulesDomain
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
fun SchedulesResponse.toDomain() = SchedulesDomain(
    schedules = this.schedules
)