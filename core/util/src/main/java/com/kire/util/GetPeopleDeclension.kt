package com.kire.util

/**
 * Склоняет слово "человек" в зависимости от количества этих самых людей
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
fun Int.getPeopleDeclension(): String {
    return when {
        this % 100 in 11..14 -> "человек"
        this % 10 == 1 -> "человек"
        this % 10 in 2..4 -> "человека"
        else -> "человек"
    }
}