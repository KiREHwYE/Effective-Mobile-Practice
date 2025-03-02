package com.kire.favourites.presentation.mapper.vacancy

import com.kire.favourites.domain.model.vacancy.SalaryDomain
import com.kire.favourites.presentation.model.vacancy.Salary


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