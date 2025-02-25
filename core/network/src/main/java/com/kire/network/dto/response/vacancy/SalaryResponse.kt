package com.kire.network.dto.response.vacancy

import kotlinx.serialization.Serializable

/**
 * Содержит информацию об уровне предлагаемого дохода
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Serializable
internal data class SalaryResponse(
    val short: String? = null,
    val full: String? = null
)
