package com.kire.jobs.presentation.screen.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import com.kire.ui.Dimens.ROUNDED_CORNERS_8
import com.kire.ui.Dimens.VERTICAL_PAD_14
import com.kire.ui.theme.extendedColor
import com.kire.ui.theme.extendedType
import com.kire.ui.util.bounceClick

/**
 * Кнопка, при нажатии на которую меняется вид топбара,
 * а также изменяется число отображаемых вакансий
 *
 * @param text текст кнопки
 * @param onClick действие при нажатии
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Composable
fun MoreVacanciesButton(
    text: String,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable {
                onClick()
            }
            .clip(RoundedCornerShape(ROUNDED_CORNERS_8))
            .background(color = extendedColor.blue)
            .padding(vertical = VERTICAL_PAD_14),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = extendedType.buttonText1,
            color = extendedColor.white
        )
    }
}