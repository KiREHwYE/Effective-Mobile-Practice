package com.kire.jobs.presentation.mapper.offer

import com.kire.jobs.domain.model.offer.OfferDomain
import com.kire.jobs.presentation.model.offer.Offer

/**
 * Конвертирует OfferDomain в Offer
 *
 * @see Offer
 * @see OfferDomain
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
fun OfferDomain.toPresentation() = Offer(
    id = this.id,
    title = this.title,
    button = this.button?.toPresentation(),
    link = this.link
)