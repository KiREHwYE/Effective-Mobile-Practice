package com.kire.jobs.presentation.mapper.offer

import com.kire.jobs.domain.model.offer.ButtonDomain
import com.kire.jobs.presentation.model.offer.Button

/**
 * Конвертирует ButtonDomain в Button
 *
 * @see ButtonDomain
 * @see Button
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
fun ButtonDomain.toPresentation() = Button(
    text = this.text
)