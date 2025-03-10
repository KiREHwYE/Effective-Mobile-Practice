package com.kire.network.dto.response.vacancy

import kotlinx.serialization.Serializable

/**
 * Содержит информацию о вакансии
 *
 * @see AddressResponse
 * @see ExperienceResponse
 * @see SalaryResponse
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Serializable
data class VacancyResponse(
    val id: String? = null,
    val lookingNumber: Int? = null,
    val title: String? = null,
    val address: AddressResponse = AddressResponse(),
    val company: String? = null,
    val experience: ExperienceResponse = ExperienceResponse(),
    val publishedDate: String? = null,
    val isFavorite: Boolean? = null,
    val salary: SalaryResponse = SalaryResponse(),
    val schedules: List<String> = emptyList(),
    val appliedNumber: Int? = null,
    val description: String? = null,
    val responsibilities: String? = null,
    val questions: List<String> = emptyList()
)
