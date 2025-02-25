package com.kire.network.dto.response.vacancy

import kotlinx.serialization.Serializable

@Serializable
data class AddressResponse(
    val town: String? = null,
    val street: String? = null,
    val house: String? = null
)
