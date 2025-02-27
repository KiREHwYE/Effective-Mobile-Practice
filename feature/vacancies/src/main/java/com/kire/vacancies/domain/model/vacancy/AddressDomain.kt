package com.kire.vacancies.domain.model.vacancy

/**
 * Содержит информацию об адресе предлагаемой вакансии
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
data class AddressDomain(
    val town: String? = null,
    val street: String? = null,
    val house: String? = null
)