package com.kire.vacancies.data.mapper.offer

import com.kire.network.dto.response.offer.ButtonResponse
import com.kire.network.dto.response.offer.OfferResponse
import com.kire.vacancies.domain.model.offer.ButtonDomain
import com.kire.vacancies.domain.model.offer.OfferDomain

/**
 * Конвертирует ButtonResponse в ButtonDomain
 *
 * @see ButtonResponse
 * @see ButtonDomain
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
fun ButtonResponse.toDomain() = ButtonDomain(
    text = this.text
)