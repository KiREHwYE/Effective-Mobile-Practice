package com.kire.ui.ui_component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import com.kire.ui.Dimens.HORIZONTAL_PAD_16
import com.kire.ui.Dimens.ROUNDED_CORNERS_8
import com.kire.ui.Dimens.VERTICAL_PAD_16
import com.kire.ui.Dimens.VERTICAL_PAD_24
import com.kire.ui.theme.extendedColor

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
    verticalArrangementDp: Dp = VERTICAL_PAD_16,
    paddingValues: PaddingValues = PaddingValues(
        vertical = VERTICAL_PAD_24,
        horizontal = HORIZONTAL_PAD_16
    ),
    content: @Composable () -> Unit
) {

    Column(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .then(modifier)
            .clip(RoundedCornerShape(ROUNDED_CORNERS_8))
            .background(color = extendedColor.grey1)
            .padding(paddingValues),
        verticalArrangement = Arrangement.spacedBy(verticalArrangementDp),
        horizontalAlignment = Alignment.Start
    ) {
        content()
    }
}