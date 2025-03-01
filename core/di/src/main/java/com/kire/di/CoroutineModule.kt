package com.kire.di

import com.kire.util.IODispatcher
import com.kire.util.DefaultDispatcher
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher

/**
 * Модуль Dagger для предоставления диспетчеров корутин:
 * - Dispatchers.IO
 * - Dispatchers.Default
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Module
object CoroutineModule {

    @Provides
    @IODispatcher
    fun provideIODispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    @DefaultDispatcher
    fun provideDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default
}