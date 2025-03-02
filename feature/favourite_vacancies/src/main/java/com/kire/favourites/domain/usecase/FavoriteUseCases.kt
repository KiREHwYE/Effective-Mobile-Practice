package com.kire.favourites.domain.usecase

import javax.inject.Inject

/**
 * Usecase'ы для получения вакансий и предложений
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
data class FavoriteUseCases @Inject constructor(
    override val getFavoriteUseCases: GetFavoriteUseCases,
): IFavoriteUseCases