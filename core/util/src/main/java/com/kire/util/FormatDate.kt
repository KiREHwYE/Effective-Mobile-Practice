package com.kire.util

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

/**
 * Конвертирует даты формата "2024-02-20" в "20 февраля"
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
fun String.formatDate(): String {
    val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale("ru"))
    val outputFormatter = DateTimeFormatter.ofPattern("d MMMM", Locale("ru"))

    val date = LocalDate.parse(this, inputFormatter)
    return date.format(outputFormatter)
}