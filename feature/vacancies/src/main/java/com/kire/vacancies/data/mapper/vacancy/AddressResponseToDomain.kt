package com.kire.vacancies.data.mapper.vacancy

import com.kire.network.dto.response.vacancy.AddressResponse
import com.kire.vacancies.domain.model.vacancy.AddressDomain

/**
 * Конвертирует AddressResponse в AddressDomain
 *
 * @see AddressResponse
 * @see AddressDomain
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
fun AddressResponse.toDomain() = AddressDomain(
    town = this.town,
    street = this.street,
    house = this.house
)