package com.kire.network.dto.response.vacancy

import kotlinx.serialization.Serializable

/**
 * Содержит информацию вакансии
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Serializable
internal data class VacancyResponse(
    val id: String? = null,
    val title: String? = null,
    val address: AddressResponse = AddressResponse(),
    val company: String? = null,
    val experience: ExperienceResponse = ExperienceResponse(),
    val publishedDate: String? = null,
    val isFavorite: Boolean? = null,
    val salary: SalaryResponse = SalaryResponse(),
    val schedules: SchedulesResponse = SchedulesResponse(),
    val appliedNumber: Int? = null,
    val description: String? = null,
    val responsibilities: String? = null,
    val questions: QuestionsResponse = QuestionsResponse()
)
