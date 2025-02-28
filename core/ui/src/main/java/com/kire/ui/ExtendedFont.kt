package com.kire.ui

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.font.FontFamily

/**
 * Содержит используемые в приложении шрифты
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Immutable
data class ExtendedFont(
    val sfProDisplayFamily: FontFamily = FontFamily()
)
