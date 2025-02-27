package com.kire.vacancies.data.mapper

import com.kire.network.dto.response.offer.ButtonResponse
import com.kire.vacancies.domain.model.offer.ButtonDomain

fun ButtonResponse.toDomain() = ButtonDomain(
    text = this.text
)