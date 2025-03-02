package com.kire.effectivemobilepractice

import androidx.annotation.DrawableRes
import com.kire.jobs.navigation.JobsRoutes

/**
 * Экраны доступные из меню
 *
 * @param route место назначения
 * @param label название экрана
 * @param icon ресурс иконки для отображения
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
enum class MenuDestinations (
    val route: String?,
    val label: String,
    @DrawableRes val icon: Int,
) {
    JOBS(JobsRoutes.Main.route, "Поиск", R.drawable.search_menu),
    FAVORITE(JobsRoutes.Main.route, "Избранное", R.drawable.favorite_menu),
    RESPONDS(null, "Отклики", R.drawable.responds_menu),
    MESSAGES(null, "Сообщения", R.drawable.messages_menu),
    PROFILE(null, "Профиль", R.drawable.profile_menu)
}