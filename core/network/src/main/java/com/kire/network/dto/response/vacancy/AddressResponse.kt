package com.kire.network.dto.response.vacancy

import kotlinx.serialization.Serializable

/**
 * Содержит информацию об адресе предлагаемой вакансии
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Serializable
internal data class AddressResponse(
    val town: String? = null,
    val street: String? = null,
    val house: String? = null
)
