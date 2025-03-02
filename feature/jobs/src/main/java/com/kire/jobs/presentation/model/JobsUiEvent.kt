package com.kire.jobs.presentation.model

/**
 * Действия доступные пользователю
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
sealed class JobsUiEvent {
    data class onHeartClick(val id: String, val isFavorite: Boolean): JobsUiEvent()
    data class onSearch(val searchText: String): JobsUiEvent() // Бутафория
    data class onSort(val sortParam: String): JobsUiEvent() // Бутафория
    data class onFilter(val filterParam: String): JobsUiEvent() // Бутафория
}