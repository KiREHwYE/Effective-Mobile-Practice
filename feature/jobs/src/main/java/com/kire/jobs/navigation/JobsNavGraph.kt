package com.kire.jobs.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.kire.jobs.presentation.viewmodel.JobsViewModel
import com.kire.jobs.presentation.JobsScreen

/**
 * Граф навигации для экранов feature:jobs
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
fun NavGraphBuilder.jobsNavGraph(
    navController: NavHostController,
    jobsViewModel: JobsViewModel
) {
    composable(JobsRoutes.Main.route) {
        JobsScreen(navController, jobsViewModel)
    }
}