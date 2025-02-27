package com.kire.vacancies.data.mapper.vacancy

import com.kire.network.dto.response.vacancy.SalaryResponse
import com.kire.vacancies.domain.model.vacancy.SalaryDomain

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