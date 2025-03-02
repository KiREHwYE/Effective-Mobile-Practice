package com.kire.util

/**
 * Склоняет слово "человек" в зависимости от количества этих самых людей
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
fun getPeopleDeclension(number: Int): String {
    return when {
        number % 100 in 11..14 -> "человек"
        number % 10 == 1 -> "человек"
        number % 10 in 2..4 -> "человека"
        else -> "человек"
    }
}