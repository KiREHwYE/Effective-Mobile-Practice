package com.kire.favourites.domain.usecase

/**
 * Usecase'ы для работы с избранными вакансиями
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
sealed interface IFavoriteUseCases {
    val getFavoriteUseCases: GetFavoriteUseCases
}