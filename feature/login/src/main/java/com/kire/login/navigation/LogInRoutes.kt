package com.kire.login.navigation

/**
 * Маршруты для навигации в пределах экранов логина (feature:login)
 *
 * @param route название маршрута для навигации
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
sealed class LogInRoutes(val route: String) {
    object LogIn: LogInRoutes("login")
    object LogInCode: LogInRoutes("login_code")
}