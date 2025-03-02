package com.kire.login.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.kire.login.presentation.LogInCodeScreen
import com.kire.login.presentation.LogInScreen

/**
 * Граф навигации для экранов логина
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
fun NavGraphBuilder.loginNavGraph(navController: NavHostController, navigateToMainScreen: () -> Unit) {
    composable(LogInRoutes.LogIn.route) { LogInScreen(navController) }
    composable(LogInRoutes.LogInCode.route) {
        LogInCodeScreen(
            navController = navController,
            navigateToMainScreen = navigateToMainScreen
        )
    }
}