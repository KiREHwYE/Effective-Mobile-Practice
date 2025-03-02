package com.kire.favourites.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kire.favourites.domain.usecase.IFavoriteUseCases
import javax.inject.Inject

/**
 * Фабрика для создания JobsViewModel с его зависимостями
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
class FavoriteViewModelFactory @Inject constructor(
    private val favoriteUseCases: IFavoriteUseCases
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FavoriteViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FavoriteViewModel(favoriteUseCases) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
