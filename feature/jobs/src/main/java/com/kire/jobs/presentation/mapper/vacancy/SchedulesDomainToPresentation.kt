package com.kire.jobs.presentation.mapper.vacancy

import com.kire.jobs.domain.model.vacancy.SchedulesDomain
import com.kire.jobs.presentation.model.vacancy.Schedules

/**
 * Конвертирует SchedulesDomain в Schedules
 *
 * @see Schedules
 * @see SchedulesDomain
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
fun SchedulesDomain.toPresentation() = Schedules(
    schedules = this.schedules
)