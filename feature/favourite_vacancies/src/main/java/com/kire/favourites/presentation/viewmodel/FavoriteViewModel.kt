package com.kire.favourites.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kire.favourites.domain.model.vacancy.VacancyDomain
import com.kire.favourites.domain.usecase.IFavoriteUseCases
import com.kire.favourites.presentation.mapper.toPresentation
import com.kire.favourites.presentation.mapper.vacancy.toPresentation
import com.kire.favourites.presentation.model.FavoriteUiEvent
import com.kire.favourites.presentation.model.IRequestResult
import com.kire.favourites.presentation.model.vacancy.Vacancy
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * ViewModel для избранных вакансий
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
class FavoriteViewModel(
    private val favoriteUseCases: IFavoriteUseCases
): ViewModel() {

    private val _requestResult: MutableStateFlow<IRequestResult> = MutableStateFlow(IRequestResult.Idle)
    val requestResult: StateFlow<IRequestResult> = _requestResult.asStateFlow()

    private val _favoriteVacancies: MutableStateFlow<List<Vacancy>> = MutableStateFlow(emptyList())
    val favoriteVacancies: StateFlow<List<Vacancy>> = _favoriteVacancies.asStateFlow()

    fun getVacancyById(id: String?) =
        _favoriteVacancies.value.first { it.id == id }

    fun OnEvent(event: FavoriteUiEvent) {
        when(event) {
            is FavoriteUiEvent.onHeartClick -> {

                // Да, нужно было по-хорошему делать это через базу данных, но я уже не успевал ее сделать
                _favoriteVacancies.value = _favoriteVacancies.value.map { vacancy ->
                    if (vacancy.id == event.id)
                        vacancy.copy(isFavorite = event.isFavorite)
                    else vacancy
                }
            }
        }
    }

    init {
        viewModelScope.launch {
            _requestResult.value = favoriteUseCases.getFavoriteUseCase().toPresentation<List<VacancyDomain>>()
                .also { result ->
                    if (result is IRequestResult.Success<*>)
                        _favoriteVacancies.value = (result.data as List<*>).map {
                            (it as VacancyDomain).toPresentation()
                        }
                }
        }
    }
}