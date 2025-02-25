package com.kire.network.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class VacancyResponse(
    val id: String? = null,
    val title: String? = null,
    val address: AddressResponse = AddressResponse(),
    val company: String? = null,
    val experience: ExperienceResponse = ExperienceResponse(),
    val publishedDate: String? = null,
    val isFavourite: Boolean? = null,
    val salary: SalaryResponse = SalaryResponse(),
    val schedules: SchedulesResponse = SchedulesResponse(),
    val appliedNumber: Int? = null,
    val description: String? = null,
    val responsibilities: String? = null,
    val questions: QuestionsResponse = QuestionsResponse()
)
