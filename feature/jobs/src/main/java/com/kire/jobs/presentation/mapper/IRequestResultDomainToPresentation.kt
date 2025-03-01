package com.kire.jobs.presentation.mapper

import com.kire.jobs.domain.model.IRequestResultDomain
import com.kire.jobs.presentation.model.IRequestResult

/**
 * Конвертирует IRequestResultDomain в IRequestResult
 *
 * @see IRequestResult
 * @see IRequestResultDomain
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
fun <T> IRequestResultDomain.toPresentation() =
    when(this) {
        is IRequestResultDomain.Success<*> -> {
            @Suppress("UNCHECKED_CAST")
            IRequestResult.Success(this.data as T)
        }

        is IRequestResultDomain.Errors ->
            IRequestResult.Errors(this.messages)

        IRequestResultDomain.Idle ->
            IRequestResult.Idle
    }