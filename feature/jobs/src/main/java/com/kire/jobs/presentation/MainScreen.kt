package com.kire.jobs.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.kire.ui.Dimens.VERTICAL_PAD_32


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

    Column (
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(VERTICAL_PAD_32),
        horizontalAlignment = Alignment.Start
    ) {
        Topbar(
            search = {
                Search()
            },
            offersCarousel = {
                OffersCarousel(
                    offers = offers
                )
            }
        )
    }
}