package com.kire.favourites.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.kire.favourites.presentation.FavoriteScreen
import com.kire.favourites.presentation.viewmodel.FavoriteViewModel

/**
 * Граф навигации для экранов feature:favorite_vacancies
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
fun NavGraphBuilder.favoriteNavGraph(
    navController: NavHostController,
    favoriteViewModel: FavoriteViewModel,
    navigateToVacancyPageWithVacancyId: (String?) -> Unit
) {
    composable(FavoriteRoutes.Favorite.route) {
        FavoriteScreen(
            favoriteViewModel = favoriteViewModel,
            navigateToVacancyPageWithVacancyId = navigateToVacancyPageWithVacancyId
        )
    }
}