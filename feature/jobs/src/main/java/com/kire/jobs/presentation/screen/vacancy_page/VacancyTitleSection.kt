package com.kire.jobs.presentation.screen.vacancy_page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.kire.jobs.presentation.model.vacancy.Vacancy
import com.kire.ui.Dimens.VERTICAL_PAD_16
import com.kire.ui.Dimens.VERTICAL_PAD_6
import com.kire.ui.theme.extendedColor
import com.kire.ui.theme.extendedType

/**
 * Часть экрана вакансии с названием вакансии
 * и краткой информации о ней
 *
 * @param vacancy вакансия
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Composable
fun VacancyTitleSection(
    vacancy: Vacancy
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        verticalArrangement = Arrangement.spacedBy(VERTICAL_PAD_16),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = vacancy.title ?: "",
            style = extendedType.title1,
            color = extendedColor.white
        )

        Text(
            text = vacancy.salary.full ?: "",
            style = extendedType.text1,
            color = extendedColor.white
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalArrangement = Arrangement.spacedBy(VERTICAL_PAD_6),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = vacancy.experience.previewText ?: "",
                style = extendedType.text1,
                color = extendedColor.white
            )

            Text(
                text = vacancy.schedules.joinToString(", "),
                style = extendedType.text1,
                color = extendedColor.white
            )
        }
    }
}