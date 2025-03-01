package com.kire.jobs.domain.model.offer

/** Содержит информацию о предложении для пользователя
 *
 * @author Михаил Гонтарев (KiREHwYE)
 * */
data class OfferDomain(
    val id: String? = null,
    val title: String? = null,
    val button: ButtonDomain? = null,
    val link: String? = null
)