package com.kire.effectivemobilepractice

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.kire.jobs.navigation.JobsRoutes
import com.kire.jobs.navigation.jobsNavGraph
import com.kire.jobs.presentation.viewmodel.JobsViewModel
import com.kire.login.navigation.LogInRoutes
import com.kire.login.navigation.loginNavGraph

/**
 * Главный граф навигации приложения
 *
 * @param navHostController для навигации
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Composable
fun MainNavHost(
    navHostController: NavHostController,
    jobsViewModel: JobsViewModel
) {
    NavHost(navController = navHostController, startDestination = LogInRoutes.LogIn.route) {
        loginNavGraph(navHostController, navigateToMainScreen = { navHostController.navigate(JobsRoutes.Main.route) })
        jobsNavGraph(navHostController, jobsViewModel)
    }
}