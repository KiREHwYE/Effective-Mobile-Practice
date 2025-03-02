package com.kire.favourites.data.mapper.vacancy

import com.kire.favourites.domain.model.vacancy.AddressDomain
import com.kire.network.dto.response.vacancy.AddressResponse

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