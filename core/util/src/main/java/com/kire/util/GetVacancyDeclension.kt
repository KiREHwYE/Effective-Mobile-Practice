package com.kire.util

/**
 * Склоняет слово "вакансия" в зависимости
 * от количества этих самых вакансий
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
fun Int.getVacancyDeclension(): String {
    val form = when {
        this % 100 in 11..19 -> "вакансий"
        this % 10 == 1 -> "вакансия"
        this % 10 in 2..4 -> "вакансии"
        else -> "вакансий"
    }
    return form
}
