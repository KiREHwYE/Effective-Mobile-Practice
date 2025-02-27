package com.kire.jobs.data.mapper.offer

import com.kire.network.dto.response.offer.ButtonResponse
import com.kire.jobs.domain.model.offer.ButtonDomain

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