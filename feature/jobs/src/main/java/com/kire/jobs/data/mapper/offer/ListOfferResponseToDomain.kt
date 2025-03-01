package com.kire.jobs.data.mapper.offer

import com.kire.network.dto.response.offer.OfferResponse

/**
 * Конвертирует List<OfferResponse> в List<OfferDomain>
 *
 * @see OfferResponse
 * @see OfferDomain
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
fun List<OfferResponse>.toDomain() = this.map { it.toDomain() }