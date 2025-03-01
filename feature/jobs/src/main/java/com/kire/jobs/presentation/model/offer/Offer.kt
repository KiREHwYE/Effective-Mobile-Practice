package com.kire.jobs.presentation.model.offer

/** Содержит информацию о предложении для пользователя
 *
 * @author Михаил Гонтарев (KiREHwYE)
 * */
data class Offer(
    val id: String? = null,
    val title: String? = null,
    val button: Button? = null,
    val link: String? = null
)