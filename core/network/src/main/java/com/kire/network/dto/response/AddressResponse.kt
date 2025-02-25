package com.kire.network.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class AddressResponse(
    val town: String? = null,
    val street: String? = null,
    val house: String? = null
)
