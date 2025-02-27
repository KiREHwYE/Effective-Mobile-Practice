package com.kire.network

import kotlinx.serialization.Serializable

/**
 * Содержит информацию об ошибках,
 * полученных в ходе неудавшегося запроса
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Serializable
data class ErrorsResponse(
    val errors: List<String> = emptyList()
): Exception()