package com.kire.util

import javax.inject.Qualifier

/**
 * Аннотация Dagger для указания Dispatchers.IO
 * при внедрении зависимостей
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class IODispatcher

/**
 * Аннотация Dagger для указания Dispatchers.Default
 * при внедрении зависимостей
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DefaultDispatcher
