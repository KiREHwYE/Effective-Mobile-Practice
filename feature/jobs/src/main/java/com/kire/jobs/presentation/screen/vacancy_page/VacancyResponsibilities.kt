package com.kire.jobs.presentation.screen.vacancy_page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kire.jobs.presentation.constant.JobsStrings.YOUR_TASKS
import com.kire.jobs.presentation.model.vacancy.Vacancy
import com.kire.ui.Dimens.VERTICAL_PAD_8
import com.kire.ui.theme.extendedColor
import com.kire.ui.theme.extendedType

/**
 * Блок с информацией о задачах в рамках вакансии
 *
 * @param vacancy вакансия
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Composable
fun VacancyResponsibilities(vacancy: Vacancy) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        verticalArrangement = Arrangement.spacedBy(VERTICAL_PAD_8)
    ) {
        Text(
            text = YOUR_TASKS,
            style = extendedType.title2,
            color = extendedColor.white
        )

        Text(
            text = vacancy.responsibilities ?: "",
            style = extendedType.text1,
            color = extendedColor.white
        )
    }
}