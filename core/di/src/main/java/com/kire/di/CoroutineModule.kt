package com.kire.di

import com.kire.util.DefaultDispatcher
import com.kire.util.IODispatcher
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

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