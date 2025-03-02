package com.kire.favourites.data.mapper.vacancy

import com.kire.favourites.domain.model.vacancy.SalaryDomain
import com.kire.network.dto.response.vacancy.SalaryResponse

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