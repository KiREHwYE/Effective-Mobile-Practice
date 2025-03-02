package com.kire.jobs.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.kire.ui.Dimens.VERTICAL_PAD_16

/**
 * Топбар экрана с вакансиями и предложениями.
 * Содержит поиск и кнопку фильтра
 */
@Composable
fun Topbar(
    modifier: Modifier = Modifier,
    search: @Composable () -> Unit = {},
    offersCarousel: @Composable () -> Unit = {}
){
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        verticalArrangement = Arrangement.spacedBy(VERTICAL_PAD_16),
        horizontalAlignment = Alignment.Start
    ) {
        search()
        offersCarousel()
    }
}