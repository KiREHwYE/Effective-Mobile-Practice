package com.kire.network.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class Offer(
    val id: String? = null,
    val title: String? = null,
    val button: ButtonResponse? = null,
    val link: String? = null
)