package com.kire.vacancies.domain.model.vacancy

data class VacancyDomain(
    val id: String? = null,
    val title: String? = null,
    val address: AddressDomain = AddressDomain(),
    val company: String? = null,
    val experience: ExperienceDomain = ExperienceDomain(),
    val publishedDate: String? = null,
    val isFavorite: Boolean? = null,
    val salary: SalaryDomain = SalaryDomain(),
    val schedules: SchedulesDomain = SchedulesDomain(),
    val appliedNumber: Int? = null,
    val description: String? = null,
    val responsibilities: String? = null,
    val questions: QuestionsDomain = QuestionsDomain()
)