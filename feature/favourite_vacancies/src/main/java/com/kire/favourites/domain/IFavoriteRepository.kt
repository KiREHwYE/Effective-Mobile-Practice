package com.kire.favourites.domain

import com.kire.favourites.domain.model.IRequestResultDomain

/**
 * Репозиторий для работы с предложениями для пользователя и вакансиями
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
interface IFavoriteRepository {
    suspend fun getFavoriteVacancies(): IRequestResultDomain
}