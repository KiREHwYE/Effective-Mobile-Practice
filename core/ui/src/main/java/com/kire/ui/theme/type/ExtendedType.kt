package com.kire.ui.theme.type

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle

/**
 * Содержит используемые в приложении стили текста
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Immutable
data class ExtendedType(
    val title1: TextStyle = TextStyle(),
    val title2: TextStyle = TextStyle(),
    val title3: TextStyle = TextStyle(),
    val title4: TextStyle = TextStyle(),
    val text1: TextStyle = TextStyle(),
    val buttonText1: TextStyle = TextStyle(),
    val buttonText2: TextStyle = TextStyle(),
    val tabText: TextStyle = TextStyle(),
    val number: TextStyle = TextStyle()
)