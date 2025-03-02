package com.kire.jobs.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.kire.jobs.presentation.constant.JobsStrings.MORE
import com.kire.jobs.presentation.constant.JobsStrings.VACANCIES
import com.kire.jobs.presentation.constant.JobsStrings.VACANCIES_FOR_YOU
import com.kire.ui.Dimens.ROUNDED_CORNERS_8
import com.kire.ui.Dimens.VERTICAL_PAD_14
import com.kire.ui.Dimens.VERTICAL_PAD_16
import com.kire.ui.Dimens.VERTICAL_PAD_32
import com.kire.ui.theme.extendedColor
import com.kire.ui.theme.extendedType
import com.kire.ui.util.bounceClick
import com.kire.ui.util.ignoreVerticalParentPadding


/**
 * Главный экран приложения со списком вакансий и предложений
 *
 * @param navController для навигации
 * @param modifier модификатор
 */
@Composable
fun MainScreen(
    navController: NavController,
    jobsViewModel: JobsViewModel,
    modifier: Modifier = Modifier
) {
    /** Список предложений для пользователя */
    val offers by jobsViewModel.offers.collectAsStateWithLifecycle()

    /** Список вакансий */
    val vacancies by jobsViewModel.vacancies.collectAsStateWithLifecycle()

    /** По-умолчанию отображаем 3 вакансии */
    var visibleVacanciesCount by rememberSaveable { mutableStateOf(3) }

    LazyColumn(
        modifier = Modifier
            .ignoreVerticalParentPadding(VERTICAL_PAD_16)
            .fillMaxSize()
            .padding(top = VERTICAL_PAD_16),
        contentPadding = PaddingValues(bottom = VERTICAL_PAD_16),
        verticalArrangement = Arrangement.spacedBy(VERTICAL_PAD_16)
    ) {

        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                verticalArrangement = Arrangement.spacedBy(VERTICAL_PAD_32)
            ) {
                Topbar(
                    search = {
                        Search()
                    },
                    offersCarousel = {
                        if (offers.isNotEmpty())
                            OffersCarousel(
                                offers = offers
                            )
                    }
                )

                Text(
                    text = VACANCIES_FOR_YOU,
                    style = extendedType.title2,
                    color = extendedColor.white
                )
            }
        }

        items(vacancies.take(visibleVacanciesCount)) { vacancy ->
            VacancyTile(vacancy = vacancy)
        }

        if (vacancies.size > visibleVacanciesCount) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .bounceClick {
                            visibleVacanciesCount = vacancies.size
                        }
                        .clip(RoundedCornerShape(ROUNDED_CORNERS_8))
                        .background(color = extendedColor.blue)
                        .padding(vertical = VERTICAL_PAD_14),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = MORE + (vacancies.size - visibleVacanciesCount) + VACANCIES,
                        style = extendedType.buttonText1,
                        color = extendedColor.white
                    )
                }
            }
        }
    }
}