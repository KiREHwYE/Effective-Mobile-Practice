package com.kire.network.dto.response.offer

import kotlinx.serialization.Serializable

/**
 * Ответ API для поля button в offer. Содержит текст кнопки
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Serializable
data class ButtonResponse(
    val text: String? = null
)
