package com.kire.ui.color

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

/**
 * Цвета, используемые в рамках приложения
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Immutable
data class ExtendedColor(

    // Basic
    val black: Color = Color.Black,
    val grey1: Color = Color(0xFF222325),
    val grey2: Color = Color(0xFF313234),
    val grey3: Color = Color(0xFF858688),
    val grey4: Color = Color(0xFF9F9F9F),
    val grey5: Color = Color(0xFFDBDBDB),
    val white: Color = Color.White,

    // Special
    val blue: Color = Color(0xFF2B7EFE),
    val darkBlue: Color = Color(0xFF00427D),
    val green: Color = Color(0xFF4CB24E),
    val darkGreen: Color = Color(0xFF015905),
    val red: Color = Color(0xFFFF0000),

    // Shadow
    val shadows: Color = Color(0xFF0C0C0C).copy(alpha = 0.9f)
)
