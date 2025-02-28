package com.kire.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.kire.ui.R

import com.kire.ui.theme.color.ExtendedColor
import com.kire.ui.theme.type.ExtendedType

val LocalExtendedColor = staticCompositionLocalOf { ExtendedColor() }

/** Цвета, используемые в приложении */
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

val LocalExtendedFont = staticCompositionLocalOf { ExtendedFont() }

/** Шрифты, используемые в приложении */
val extendedFont = ExtendedFont(
    sfProDisplayFamily = FontFamily(
        Font(R.font.sf_pro_display_regular, FontWeight.W400),
        Font(R.font.sf_pro_display_medium, FontWeight.Medium),
        Font(R.font.sf_pro_display_semibold, FontWeight.SemiBold)
    )
)

val LocalExtendedType = staticCompositionLocalOf { ExtendedType() }

/** Стили текста, используемые в приложении */
val extendedType = ExtendedType(
    title1 = TextStyle(
        fontSize = 22.sp,
        fontWeight = FontWeight.SemiBold,
        fontFamily = extendedFont.sfProDisplayFamily
    ),
    title2 = TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold,
        fontFamily = extendedFont.sfProDisplayFamily
    ),
    title3 = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = extendedFont.sfProDisplayFamily
    ),
    title4 = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = extendedFont.sfProDisplayFamily
    ),
    text1 = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.W400,
        fontFamily = extendedFont.sfProDisplayFamily
    ),
    buttonText1 = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
        fontFamily = extendedFont.sfProDisplayFamily
    ),
    buttonText2 = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.W400,
        fontFamily = extendedFont.sfProDisplayFamily
    ),
    tabText = TextStyle(
        fontSize = 10.sp,
        fontWeight = FontWeight.W400,
        fontFamily = extendedFont.sfProDisplayFamily
    ),
    number = TextStyle(
        fontSize = 7.sp,
        fontWeight = FontWeight.W400,
        fontFamily = extendedFont.sfProDisplayFamily
    )
)


/**
 * Расширенная тема для приложения с
 * кастомными шрифтами, стилями текста и цветами
 *
 * @param content контент для отрисовки
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Composable
fun EffectiveMobileExtendedPracticeTheme(
//    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    /*
       Если бы была еще и дневная тема, то можно было бы сделать так:
       val extendedColors = if (darkTheme) extendedDarkColors else extendedLightColors,
       соответственно определив выше отдельно цвета для дневной и ночной тем.

       Но по макету только темная тема(
     */

    CompositionLocalProvider(
        LocalExtendedColor provides extendedColor,
        LocalExtendedType provides extendedType,
        LocalExtendedFont provides  extendedFont
    ) {
        EffectiveMobilePracticeTheme(content = content)
    }
}

/**
 * Объект для быстрого доступа с цветам, шрифтам и стилям текста
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
object ExtendedTheme {
    val extendedColor: ExtendedColor
        @Composable
        @ReadOnlyComposable
        get() = LocalExtendedColor.current

    val extendedType: ExtendedType
        @Composable
        @ReadOnlyComposable
        get() = LocalExtendedType.current

    val extendedFont: ExtendedFont
        @Composable
        @ReadOnlyComposable
        get() = LocalExtendedFont.current
}