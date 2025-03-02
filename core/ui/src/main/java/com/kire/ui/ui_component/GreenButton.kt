package com.kire.ui.ui_component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.kire.ui.Dimens.ROUNDED_CORNERS_50_PERCENT
import com.kire.ui.Dimens.VERTICAL_PAD_7
import com.kire.ui.theme.extendedColor
import com.kire.ui.theme.extendedType
import com.kire.ui.util.bounceClick

/**
 * Зеленая кнопка, которая часто встречается в UI приложения
 *
 * @param text текст кнопки
 * @param action действие по нажатию на кнопку
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Composable
fun GreenButton(
    text: String,
    action: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .bounceClick {
                action()
            }
            .clip(RoundedCornerShape(ROUNDED_CORNERS_50_PERCENT))
            .background(extendedColor.green)
            .padding(vertical = VERTICAL_PAD_7),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = extendedType.buttonText2,
            color = extendedColor.white
        )
    }
}