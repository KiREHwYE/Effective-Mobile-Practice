package com.kire.favourites.domain.model.vacancy

/**
 * Содержит информацию о вакансии
 *
 * @see AddressDomain
 * @see ExperienceDomain
 * @see SchedulesDomain
 * @see SchedulesDomain
 * @see QuestionsDomain
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
data class VacancyDomain(
    val id: String? = null,
    val lookingNumber: Int? = null,
    val title: String? = null,
    val address: AddressDomain = AddressDomain(),
    val company: String? = null,
    val experience: ExperienceDomain = ExperienceDomain(),
    val publishedDate: String? = null,
    val isFavorite: Boolean? = null,
    val salary: SalaryDomain = SalaryDomain(),
    val schedules: List<String> = emptyList(),
    val appliedNumber: Int? = null,
    val description: String? = null,
    val responsibilities: String? = null,
    val questions: List<String> = emptyList()
)