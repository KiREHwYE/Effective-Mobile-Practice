package com.kire.network.dto.response.offer

import kotlinx.serialization.Serializable

@Serializable
data class OfferResponse(
    val id: String? = null,
    val title: String? = null,
    val button: ButtonResponse? = null,
    val link: String? = null
)