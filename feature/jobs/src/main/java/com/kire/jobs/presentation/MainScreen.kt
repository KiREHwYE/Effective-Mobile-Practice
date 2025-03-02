package com.kire.jobs.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.kire.jobs.presentation.constant.JobsStrings.VACANCIES_FOR_YOU
import com.kire.ui.Dimens.VERTICAL_PAD_16
import com.kire.ui.Dimens.VERTICAL_PAD_32
import com.kire.ui.theme.extendedColor
import com.kire.ui.theme.extendedType
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

        items(vacancies) { vacancy ->
            VacancyTile(vacancy = vacancy)
        }
    }
}