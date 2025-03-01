package com.kire.jobs.data.mapper.offer

import com.kire.jobs.data.mapper.vacancy.toDomain
import com.kire.network.dto.response.vacancy.VacancyResponse

/**
 * Конвертирует List<VacancyResponse> в List<VacancyDomain>
 *
 * @see VacancyResponse
 * @see VacancyDomain
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
fun List<VacancyResponse>.toDomain() = this.map { it.toDomain() }