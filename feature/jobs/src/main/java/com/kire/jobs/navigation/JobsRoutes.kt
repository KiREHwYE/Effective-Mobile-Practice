package com.kire.jobs.navigation

/**
 * Маршруты для навигации в пределах главного экрана (feature:jobs)
 *
 * @param route название маршрута для навигации
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
sealed class JobsRoutes(val route: String) {
    object Main: JobsRoutes("main")
}