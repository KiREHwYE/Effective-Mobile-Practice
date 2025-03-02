package com.kire.favourites.domain.model

/**
 * Ответ от сервера.
 * Если все в порядке - Success с необходимыми данными
 * Если нет - Errors со списком ошибок
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
sealed interface IRequestResultDomain {
    class Success<T>(val data: T): IRequestResultDomain
    class Errors(val messages: List<String?>): IRequestResultDomain

    object Idle: IRequestResultDomain
}