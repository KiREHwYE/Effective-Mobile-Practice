package com.kire.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.kire.ui.color.ExtendedColor

val LocalExtendedColor = staticCompositionLocalOf { ExtendedColor() }

val extendedColor = ExtendedColor(
    // Basic
    black = Color.Black,
    grey1 = Color(0xFF222325),
    grey2 = Color(0xFF313234),
    grey3 = Color(0xFF858688),
    grey4 = Color(0xFF9F9F9F),
    grey5 = Color(0xFFDBDBDB),
    white = Color.White,

    // Special
    blue = Color(0xFF2B7EFE),
    darkBlue = Color(0xFF00427D),
    green = Color(0xFF4CB24E),
    darkGreen = Color(0xFF015905),
    red = Color(0xFFFF0000),

    // Shadow
    shadows = Color(0xFF0C0C0C).copy(alpha = 0.9f)
)

@Composable
fun EffectiveMobileExtendedPracticeTheme(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalExtendedColor provides extendedColor
    ) {
        EffectiveMobilePracticeTheme(content = content)
    }
}

object ExtendedTheme {
    val extendedColor: ExtendedColor
        @Composable
        @ReadOnlyComposable
        get() = LocalExtendedColor.current
}