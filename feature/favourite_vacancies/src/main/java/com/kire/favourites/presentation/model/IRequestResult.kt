package com.kire.favourites.presentation.model

/**
 * Ответ от сервера.
 * Если все в порядке - Success с необходимыми данными
 * Если нет - Errors со списком ошибок
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
sealed interface IRequestResult {
    class Success<T>(val data: T): IRequestResult
    class Errors(val messages: List<String?>): IRequestResult

    object Idle: IRequestResult
}