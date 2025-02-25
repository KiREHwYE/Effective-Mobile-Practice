package com.kire.network.dto.response.offer

import kotlinx.serialization.Serializable

/**
 * Содержит текст кнопки
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Serializable
internal data class ButtonResponse(
    val text: String? = null
)
