package com.kire.favourites.presentation.model.vacancy

/**
 * Содержит информацию о вакансии
 *
 * @see Address
 * @see Experience
 * @see Schedules
 * @see Schedules
 * @see Questions
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
data class Vacancy(
    val id: String? = null,
    val lookingNumber: Int? = null,
    val title: String? = null,
    val address: Address = Address(),
    val company: String? = null,
    val experience: Experience = Experience(),
    val publishedDate: String? = null,
    val isFavorite: Boolean? = null,
    val salary: Salary = Salary(),
    val schedules: List<String> = emptyList(),
    val appliedNumber: Int? = null,
    val description: String? = null,
    val responsibilities: String? = null,
    val questions: List<String> = emptyList()
)