package com.kire.favourites.navigation

/**
 * Маршруты для навигации в пределах экрана избранного (feature:favorite_vacancies)
 *
 * @param route название маршрута для навигации
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
sealed class FavoriteRoutes(val route: String) {
    object Favorite: FavoriteRoutes("favorite")
}