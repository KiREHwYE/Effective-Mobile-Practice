package com.kire.ui.ui_component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.kire.ui.Dimens.HORIZONTAL_PAD_16
import com.kire.ui.Dimens.VERTICAL_PAD_16
import com.kire.ui.theme.extendedColor

/**
 * Базовый компонент, поверх которого отрисовывается content
 *
 * @param bottomMenu меню для навигации
 * @param content UI для отрисовки
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Composable
fun BaseLayout(
    bottomMenu: @Composable () -> Unit = {},
    content: @Composable () -> Unit = {}
) {
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(color = extendedColor.black)
//            .windowInsetsPadding(WindowInsets.displayCutout)
//            .padding(
//                PaddingValues(
//                    horizontal = HORIZONTAL_PAD_16,
//                    vertical = VERTICAL_PAD_16
//                )
//            )
//    ) {
//        content()
//
//        bottomMenu(Modifier.align(Alignment.BottomCenter))
//    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = extendedColor.black)
            .windowInsetsPadding(WindowInsets.displayCutout)
            .padding(
                horizontal = HORIZONTAL_PAD_16,
                vertical = VERTICAL_PAD_16
            )
    ) {
        Box(modifier = Modifier.weight(1f)) {
            content()
        }

        bottomMenu()
    }
}