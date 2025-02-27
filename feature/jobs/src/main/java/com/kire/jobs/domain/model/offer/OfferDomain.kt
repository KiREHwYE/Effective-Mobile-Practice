package com.kire.jobs.domain.model.offer

data class OfferDomain(
    val id: String? = null,
    val title: String? = null,
    val button: ButtonDomain? = null,
    val link: String? = null
)