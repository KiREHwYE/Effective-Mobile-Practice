package com.kire.network

/**
 * Содержит эндпоинты
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
internal object HttpRoutes {
    val HOST: String
        get() = "drive.usercontent.google.com"
    val MOCK_URL: List<String>
        get() = listOf("u", "0", "uc")

    val MOCK_URL_PARAMS: List<UrlParameter>
        get() = listOf(UrlParameter("id", "1z4TbeDkbfXkvgpoJprXbN85uCcD7f00r"), UrlParameter("export", "download"))
}

/**
 * Содержит информацию о параметре в URL
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
internal data class UrlParameter(
    val name: String,
    val value: String
)