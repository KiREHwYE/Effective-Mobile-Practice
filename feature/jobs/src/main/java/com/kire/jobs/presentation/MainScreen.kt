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
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.kire.jobs.presentation.constant.Amounts.VACANCIES_TO_SHOW
import com.kire.jobs.presentation.constant.JobsStrings.MORE
import com.kire.jobs.presentation.constant.JobsStrings.VACANCIES
import com.kire.jobs.presentation.constant.JobsStrings.VACANCIES_FOR_YOU
import com.kire.jobs.presentation.model.JobsUiEvent
import com.kire.jobs.presentation.topblock.OffersCarousel
import com.kire.jobs.presentation.topblock.Search
import com.kire.jobs.presentation.topblock.Sorting
import com.kire.jobs.presentation.topblock.Topbar
import com.kire.jobs.presentation.viewmodel.JobsViewModel
import com.kire.ui.Dimens.ROUNDED_CORNERS_8
import com.kire.ui.Dimens.VERTICAL_PAD_14
import com.kire.ui.Dimens.VERTICAL_PAD_16
import com.kire.ui.Dimens.VERTICAL_PAD_32
import com.kire.ui.theme.ExtendedTheme
import com.kire.ui.theme.extendedColor
import com.kire.ui.theme.extendedType
import com.kire.ui.util.bounceClick
import com.kire.ui.util.ignoreVerticalParentPadding
import com.kire.vacancies.R

/**
 * Отражает состояние главного экрана.
 * ONLY_THREE_SHOWN -> начальное состояние
 * ALL_SHOWN -> после нажатия на кнопку "Еще N вакансий"
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
private enum class JobsScreenState {
    ONLY_THREE_SHOWN,
    ALL_SHOWN
}

/**
 * Главный экран приложения со списком вакансий и предложений
 *
 * @param navController для навигации
 * @param modifier модификатор
 */
@Composable
fun JobsScreen(
    navController: NavController,
    jobsViewModel: JobsViewModel,
    modifier: Modifier = Modifier
) {
    /** Список предложений для пользователя */
    val offers by jobsViewModel.offers.collectAsStateWithLifecycle()

    /** Список вакансий */
    val vacancies by jobsViewModel.vacancies.collectAsStateWithLifecycle()

    /** Состояние экрана */
    var jobsScreenState: JobsScreenState by rememberSaveable {
        mutableStateOf(JobsScreenState.ONLY_THREE_SHOWN)
    }

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
                // Топбар
                Topbar(
                    search = {
                        Search(
                            onSearch = { searchText ->
                                jobsViewModel.OnEvent(
                                    JobsUiEvent.onSearch(searchText)
                                )
                            },
                            onFilter = { filterParam ->
                                jobsViewModel.OnEvent(
                                    JobsUiEvent.onFilter(filterParam)
                                )
                            },
                            icon = {
                                if (jobsScreenState.equals(JobsScreenState.ALL_SHOWN))
                                    Icon(
                                        painter = painterResource(R.drawable.arrow_back),
                                        contentDescription = "Back",
                                        tint = ExtendedTheme.extendedColor.white,
                                        modifier = Modifier
                                            .bounceClick {
                                                jobsScreenState = JobsScreenState.ONLY_THREE_SHOWN
                                            }
                                    )
                                else
                                    Icon(
                                        painter = painterResource(R.drawable.search),
                                        contentDescription = "Search",
                                        tint = ExtendedTheme.extendedColor.grey4
                                    )
                            }
                        )
                    },
                    additional = {
                        if (offers.isNotEmpty() && jobsScreenState.equals(JobsScreenState.ONLY_THREE_SHOWN))
                            OffersCarousel(
                                offers = offers
                            )
                        else if (jobsScreenState.equals(JobsScreenState.ONLY_THREE_SHOWN))
                            Sorting(
                                vacanciesNumber = vacancies.size,
                                onSort = { sortParam ->
                                    jobsViewModel.OnEvent(
                                        JobsUiEvent.onFilter(sortParam)
                                    )
                                }
                            )
                    }
                )

                // Текст "Вакансии для вас"
                if (jobsScreenState.equals(JobsScreenState.ONLY_THREE_SHOWN))
                    Text(
                        text = VACANCIES_FOR_YOU,
                        style = extendedType.title2,
                        color = extendedColor.white
                    )
            }
        }

        // Плитки вакансий
        items(vacancies.take(VACANCIES_TO_SHOW)) { vacancy ->
            VacancyTile(
                vacancy = vacancy,
                onHeartClick = {
                    vacancy.id?.let { id ->
                        jobsViewModel.OnEvent(
                            JobsUiEvent.onHeartClick(id, !(vacancy.isFavorite ?: false))
                        )
                    }
                }
            )
        }

        // Кнопка, при нажатии на которую меняется вид топбара,
        // а также изменяется число отображаемых вакансий
        if (offers.isNotEmpty() && jobsScreenState.equals(JobsScreenState.ONLY_THREE_SHOWN)) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .bounceClick {
                            jobsScreenState = JobsScreenState.ALL_SHOWN
                        }
                        .clip(RoundedCornerShape(ROUNDED_CORNERS_8))
                        .background(color = extendedColor.blue)
                        .padding(vertical = VERTICAL_PAD_14),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = MORE + (vacancies.size - VACANCIES_TO_SHOW) + VACANCIES,
                        style = extendedType.buttonText1,
                        color = extendedColor.white
                    )
                }
            }
        }
    }
}