package com.kire.jobs.presentation.model.vacancy

/**
 * Содержит информацию об адресе предлагаемой вакансии
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
data class Address(
    val town: String? = null,
    val street: String? = null,
    val house: String? = null
)
