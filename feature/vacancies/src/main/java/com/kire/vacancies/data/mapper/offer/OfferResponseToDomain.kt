package com.kire.vacancies.data.mapper.offer

import com.kire.network.dto.response.offer.OfferResponse
import com.kire.vacancies.domain.model.offer.OfferDomain

/**
 * Конвертирует OfferResponse в OfferDomain
 *
 * @see OfferResponse
 * @see OfferDomain
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
fun OfferResponse.toDomain() = OfferDomain(
    id = this.id,
    title = this.title,
    button = this.button?.toDomain(),
    link = this.link
)