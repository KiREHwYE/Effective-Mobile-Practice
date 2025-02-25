package com.kire.network.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class SalaryResponse(
    val short: String? = null,
    val full: String? = null
)
