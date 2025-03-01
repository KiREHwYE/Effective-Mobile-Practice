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
fun NavGraphBuilder.loginNavGraph(navController: NavHostController) {
    composable(LoginRoutes.Login.route) { LogInScreen(navController) }
    composable(LoginRoutes.LoginCode.route) { LogInCodeScreen(navController) }
}