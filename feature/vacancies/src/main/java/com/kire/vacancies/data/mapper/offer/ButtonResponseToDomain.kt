package com.kire.vacancies.data.mapper.offer

import com.kire.network.dto.response.offer.ButtonResponse
import com.kire.vacancies.domain.model.offer.ButtonDomain

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