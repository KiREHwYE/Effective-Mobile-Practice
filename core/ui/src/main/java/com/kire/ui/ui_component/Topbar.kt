package com.kire.ui.ui_component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.kire.ui.theme.extendedColor
import com.kire.ui.theme.extendedType

/**
 * Заголовок экрана логина
 *
 * @param modifier модификатор
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Composable
fun Topbar(
    modifier: Modifier = Modifier,
    text: String = ""
) {

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            contentAlignment = Alignment.BottomStart
        ) {
            Text(
                text =  text,
                style = extendedType.title2,
                color = extendedColor.white
            )
        }
    }
}