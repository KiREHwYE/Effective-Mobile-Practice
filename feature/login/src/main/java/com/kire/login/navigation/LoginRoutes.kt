package com.kire.login.navigation

/**
 * Маршруты для навигации в пределах экранов логина (feature:login)
 *
 * @param route название маршрута для навигации
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
sealed class LoginRoutes(val route: String) {
    object Login: LoginRoutes("login")
    object LoginCode: LoginRoutes("login_code")
}