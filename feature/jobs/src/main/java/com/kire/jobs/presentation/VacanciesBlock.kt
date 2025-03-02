package com.kire.jobs.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.kire.jobs.presentation.constant.JobsStrings.APPLY_FOR
import com.kire.jobs.presentation.constant.JobsStrings.NOW_LOOKING
import com.kire.jobs.presentation.constant.JobsStrings.PUBLISHED
import com.kire.jobs.presentation.constant.JobsStrings.VACANCIES_FOR_YOU
import com.kire.jobs.presentation.model.vacancy.Vacancy
import com.kire.ui.Dimens.HORIZONTAL_PAD_8
import com.kire.ui.Dimens.VERTICAL_PAD_10
import com.kire.ui.Dimens.VERTICAL_PAD_16
import com.kire.ui.Dimens.VERTICAL_PAD_21
import com.kire.ui.Dimens.VERTICAL_PAD_4
import com.kire.ui.theme.extendedColor
import com.kire.ui.theme.extendedType
import com.kire.ui.ui_component.GreenButton
import com.kire.ui.ui_component.Tile
import com.kire.util.formatDate
import com.kire.util.getPeopleDeclension
import com.kire.vacancies.R

/**
 * Плитка с краткой информацией о вакансии
 *
 * @param modifier модификатор
 * @param vacancies список вакансий
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Composable
fun VacanciesBlock(
    modifier: Modifier = Modifier,
    vacancies: List<Vacancy> = emptyList()
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        verticalArrangement = Arrangement.spacedBy(VERTICAL_PAD_16),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = VACANCIES_FOR_YOU,
            style = extendedType.title2,
            color = extendedColor.white
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            contentPadding = PaddingValues(bottom = VERTICAL_PAD_16),
            verticalArrangement = Arrangement.spacedBy(VERTICAL_PAD_16)
        ) {
            items(vacancies) { vacancy ->
                VacancyTile(vacancy = vacancy)
            }
        }
    }
}