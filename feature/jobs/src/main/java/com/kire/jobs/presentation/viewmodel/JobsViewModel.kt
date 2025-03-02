package com.kire.jobs.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kire.jobs.domain.model.offer.OfferDomain
import com.kire.jobs.domain.model.vacancy.VacancyDomain
import com.kire.jobs.domain.usecase.IJobsUseCases
import com.kire.jobs.presentation.mapper.offer.toPresentation
import com.kire.jobs.presentation.mapper.toPresentation
import com.kire.jobs.presentation.mapper.vacancy.toPresentation
import com.kire.jobs.presentation.model.IRequestResult
import com.kire.jobs.presentation.model.JobsUiEvent
import com.kire.jobs.presentation.model.offer.Offer
import com.kire.jobs.presentation.model.vacancy.Vacancy
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * ViewModel для vacancies, offers и UI-events
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
class JobsViewModel(
    private val jobsUseCases: IJobsUseCases
): ViewModel() {

    private val _requestResult: MutableStateFlow<IRequestResult> = MutableStateFlow(IRequestResult.Idle)
    val requestResult: StateFlow<IRequestResult> = _requestResult.asStateFlow()

    private val _vacancies: MutableStateFlow<List<Vacancy>> = MutableStateFlow(emptyList())
    val vacancies: StateFlow<List<Vacancy>> = _vacancies.asStateFlow()

    private val _offers: MutableStateFlow<List<Offer>> = MutableStateFlow(emptyList())
    val offers: StateFlow<List<Offer>> = _offers.asStateFlow()

    fun OnEvent(event: JobsUiEvent) {
        when(event) {
            is JobsUiEvent.onHeartClick -> {

                // Да, нужно было по-хорошему делать это через базу данных, но я уже не успевал ее сделать
                _vacancies.value = _vacancies.value.map { vacancy ->
                    if (vacancy.id == event.id)
                        vacancy.copy(isFavorite = event.isFavorite)
                    else vacancy
                }
            }
            is JobsUiEvent.onSearch -> {
                // Бутафория
            }
            is JobsUiEvent.onSort -> {
                // Бутафория
            }
            is JobsUiEvent.onFilter -> {
                // Бутафория
            }
        }
    }

    init {
        viewModelScope.launch {
            _requestResult.value = jobsUseCases.getVacanciesUseCase().toPresentation<List<VacancyDomain>>()
                .also { result ->
                    if (result is IRequestResult.Success<*>)
                        _vacancies.value = (result.data as List<*>).map {
                            (it as VacancyDomain).toPresentation()
                        }
                }
        }

        viewModelScope.launch {
            _requestResult.value = jobsUseCases.getOffersUseCase().toPresentation<List<OfferDomain>>()
                .also { result ->
                    if (result is IRequestResult.Success<*>)
                        _offers.value = (result.data as List<*>).map {
                            (it as OfferDomain).toPresentation()
                        }
                }
        }
    }
}