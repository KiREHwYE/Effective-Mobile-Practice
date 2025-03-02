package com.kire.ui.ui_component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kire.ui.Dimens.HORIZONTAL_PAD_16
import com.kire.ui.Dimens.VERTICAL_PAD_16
import com.kire.ui.theme.extendedColor

/**
 * Базовый компонент, поверх которого отрисовывается content
 *
 * @param content UI для отрисовки. Получает PaddingValues для добавления паддингов по необходимости
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Composable
fun BaseLayout(
    content: @Composable (PaddingValues) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = extendedColor.black)
            .windowInsetsPadding(WindowInsets.displayCutout)
    ) {
        content(
            PaddingValues(
                horizontal = HORIZONTAL_PAD_16,
                vertical = VERTICAL_PAD_16
            )
        )
    }
}