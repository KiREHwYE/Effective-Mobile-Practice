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

                Tile(
                    verticalArrangementDp = VERTICAL_PAD_21
                ) {
                    Column(
                        modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        verticalArrangement = Arrangement.spacedBy(VERTICAL_PAD_10)
                    ) {
                        // Сколько людей просматривает и иконка сердечка
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(IntrinsicSize.Max),
                            verticalAlignment = Alignment.Top,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            vacancy.lookingNumber?.let {
                                Text(
                                    text = NOW_LOOKING + it + " " + it.getPeopleDeclension(),
                                    style = extendedType.text1,
                                    color = extendedColor.green
                                )
                            }

                            Icon(
                                painter = painterResource(
                                    if (vacancy.isFavorite == true)
                                        R.drawable.filled_heart
                                    else R.drawable.unfilled_heart
                                ),
                                contentDescription = "Heart" ,
                                tint = if (vacancy.isFavorite == true)
                                    extendedColor.blue
                                else extendedColor.grey2
                            )
                        }

                        // Название вакансии
                        Text(
                            text = vacancy.title ?: "",
                            style = extendedType.title3,
                            color = extendedColor.white
                        )

                        // Адрес, название компании и значок аккредитации
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight(),
                            horizontalAlignment = Alignment.Start,
                            verticalArrangement = Arrangement.spacedBy(VERTICAL_PAD_4)
                        ) {
                            Text(
                                text = vacancy.address.town ?: "",
                                style = extendedType.text1,
                                color = extendedColor.white
                            )

                            Row(
                                modifier = Modifier
                                    .wrapContentSize(),
                                horizontalArrangement = Arrangement.spacedBy(HORIZONTAL_PAD_8)
                            ) {
                                Text(
                                    text = vacancy.company ?: "",
                                    style = extendedType.text1,
                                    color = extendedColor.white
                                )

                                Icon(
                                    painter = painterResource(R.drawable.accreditation),
                                    contentDescription = "Accreditation",
                                    tint = extendedColor.grey3
                                )
                            }
                        }

                        // Иконка портфеля и опыт работы
                        Row(
                            modifier = Modifier
                                .wrapContentSize(),
                            horizontalArrangement = Arrangement.spacedBy(HORIZONTAL_PAD_8)
                        ) {

                            Icon(
                                painter = painterResource(R.drawable.briefcase),
                                contentDescription = "Accreditation",
                                tint = extendedColor.white
                            )

                            Text(
                                text = vacancy.experience.previewText ?: "",
                                style = extendedType.text1,
                                color = extendedColor.white
                            )
                        }

                        Text(
                            text = PUBLISHED + vacancy.publishedDate?.formatDate(),
                            style = extendedType.text1,
                            color = extendedColor.grey3
                        )
                    }

                    // Кнопка "Откликнуться"
                    GreenButton(
                        text = APPLY_FOR,
                        action = {
                            // По тех. заданию нерабочая
                        }
                    )
                }
            }
        }
    }
}