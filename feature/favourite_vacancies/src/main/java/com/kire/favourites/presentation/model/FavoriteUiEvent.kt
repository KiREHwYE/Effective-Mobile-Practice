package com.kire.favourites.presentation.model

/**
 * Действия доступные пользователю
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
sealed class FavoriteUiEvent {
    data class onHeartClick(val id: String, val isFavorite: Boolean): FavoriteUiEvent()
}