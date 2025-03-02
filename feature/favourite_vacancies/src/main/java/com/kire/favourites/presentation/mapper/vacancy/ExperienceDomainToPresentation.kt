package com.kire.favourites.presentation.mapper.vacancy

import com.kire.favourites.domain.model.vacancy.ExperienceDomain
import com.kire.favourites.presentation.model.vacancy.Experience


/**
 * Конвертирует ExperienceDomain в Experience
 *
 * @see Experience
 * @see ExperienceDomain
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
fun ExperienceDomain.toPresentation() = Experience(
    previewText = this.previewText,
    text = this.text
)