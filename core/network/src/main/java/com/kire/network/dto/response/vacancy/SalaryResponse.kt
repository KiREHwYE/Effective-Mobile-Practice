package com.kire.network.dto.response.vacancy

import kotlinx.serialization.Serializable

@Serializable
data class SalaryResponse(
    val short: String? = null,
    val full: String? = null
)
