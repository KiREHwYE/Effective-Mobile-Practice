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
 * Содержит поиск, кнопку фильтра, карусель предложений
 * и текст "Вакансии для вас"
 *
 * @param modifier модификатор
 * @param search поиск и кнопка фильтра
 * @param offersCarousel карусель плиток предложений для пользователся
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Composable
fun TopbarWithOffers(
    modifier: Modifier = Modifier,
    search: @Composable () -> Unit = {},
    offersCarousel: @Composable () -> Unit = {}
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        verticalArrangement = Arrangement.spacedBy(VERTICAL_PAD_32)
    ) {
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

        Text(
            text = VACANCIES_FOR_YOU,
            style = extendedType.title2,
            color = extendedColor.white
        )
    }
}