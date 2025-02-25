package com.kire.network.dto

import kotlinx.serialization.Serializable

/**
 * Содержит информацию об ошибках,
 * полученных в ходе неудавшегося запроса
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Serializable
internal data class Errors(
    val errors: List<String> = emptyList()
): Exception()