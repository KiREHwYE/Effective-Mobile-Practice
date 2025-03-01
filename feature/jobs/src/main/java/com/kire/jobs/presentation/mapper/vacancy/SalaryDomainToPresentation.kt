package com.kire.jobs.presentation.mapper.vacancy

import com.kire.jobs.domain.model.vacancy.SalaryDomain
import com.kire.jobs.presentation.model.vacancy.Salary

/**
 * Конвертирует SalaryDomain в Salary
 *
 * @see Salary
 * @see SalaryDomain
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
fun SalaryDomain.toPresentation() = Salary(
    short = this.short,
    full = this.full
)