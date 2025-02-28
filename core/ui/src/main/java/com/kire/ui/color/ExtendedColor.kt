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
    val black: Color = Color.Unspecified,
    val grey1: Color =  Color.Unspecified,
    val grey2: Color =  Color.Unspecified,
    val grey3: Color =  Color.Unspecified,
    val grey4: Color =  Color.Unspecified,
    val grey5: Color =  Color.Unspecified,
    val white: Color =  Color.Unspecified,

    // Special
    val blue: Color =  Color.Unspecified,
    val darkBlue: Color =  Color.Unspecified,
    val green: Color =  Color.Unspecified,
    val darkGreen: Color =  Color.Unspecified,
    val red: Color =  Color.Unspecified,

    // Shadow
    val shadows: Color =  Color.Unspecified
)
