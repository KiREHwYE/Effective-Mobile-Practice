package com.kire.ui.ui_component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize

import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import com.kire.ui.Dimens.HORIZONTAL_PAD_16
import com.kire.ui.Dimens.VERTICAL_PAD_24

/**
 * Контейнер, представляющий собой плитку,
 * используемую для отображения основных
 * функциональных компонентов приложения.
 * Например, плитка вакансии.
 *
 * @param modifier модификатор
 * @param content содержимое плитки
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Composable
fun Tile(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .wrapContentSize()
            .padding(
                vertical = VERTICAL_PAD_24,
                horizontal = HORIZONTAL_PAD_16
            ),
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}