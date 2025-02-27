package com.kire.di

import com.kire.util.IODispatcher
import com.kire.util.DefaultDispatcher
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

import dagger.Module
import dagger.Provides

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
    fun provideIODispatcher(): CoroutineContext = Dispatchers.IO

    @Provides
    @DefaultDispatcher
    fun provideDefaultDispatcher(): CoroutineContext = Dispatchers.Default
}