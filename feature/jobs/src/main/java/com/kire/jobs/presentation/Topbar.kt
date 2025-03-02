package com.kire.jobs.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.kire.jobs.presentation.constant.JobsStrings.VACANCIES_FOR_YOU
import com.kire.ui.Dimens.VERTICAL_PAD_16
import com.kire.ui.Dimens.VERTICAL_PAD_32
import com.kire.ui.theme.extendedColor
import com.kire.ui.theme.extendedType

/**
 * Топбар экрана с вакансиями и предложениями.
 * Содержит поиск и кнопку фильтра, а так дополнительный блок
 *
 * @param modifier модификатор
 * @param search поиск и кнопка фильтра
 * @param additional дополнительный контент для отрисовки под поиском
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Composable
fun Topbar(
    modifier: Modifier = Modifier,
    search: @Composable () -> Unit = {},
    additional: @Composable () -> Unit = {}
){
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        verticalArrangement = Arrangement.spacedBy(VERTICAL_PAD_16),
        horizontalAlignment = Alignment.Start
    ) {
        search()
        additional()
    }
}