package com.kire.vacancies.domain.model.offer

import com.kire.network.dto.response.offer.ButtonResponse

data class OfferDomain(
    val id: String? = null,
    val title: String? = null,
    val button: ButtonDomain? = null,
    val link: String? = null
)