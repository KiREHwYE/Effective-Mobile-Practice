package com.kire.favourites.data.mapper.vacancy

import com.kire.network.dto.response.vacancy.SalaryResponse
import com.kire.jobs.domain.model.vacancy.SalaryDomain

/**
 * Конвертирует SalaryResponse в SalaryDomain
 *
 * @see SalaryResponse
 * @see SalaryDomain
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
fun SalaryResponse.toDomain() = SalaryDomain(
    short = this.short,
    full = this.full
)