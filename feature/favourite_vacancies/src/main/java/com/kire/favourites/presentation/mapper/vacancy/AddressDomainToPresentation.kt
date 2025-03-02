package com.kire.favourites.presentation.mapper.vacancy

import com.kire.favourites.domain.model.vacancy.AddressDomain
import com.kire.favourites.presentation.model.vacancy.Address

/**
 * Конвертирует AddressDomain в Address
 *
 * @see Address
 * @see AddressDomain
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
fun AddressDomain.toPresentation() = Address(
    town = this.town,
    street = this.street,
    house = this.house
)