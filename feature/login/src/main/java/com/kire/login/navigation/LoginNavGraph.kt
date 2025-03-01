package com.kire.login.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.kire.login.presentation.LoginScreen

/**
 * Граф навигации для экранов логина
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
fun NavGraphBuilder.loginNavGraph(navController: NavController) {
    composable(LoginRoutes.Login.route) { LoginScreen(navController) }
    composable(LoginRoutes.LoginCode.route) {  }
}