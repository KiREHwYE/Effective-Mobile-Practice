package com.kire.di

import com.kire.util.IODispatcher
import com.kire.util.DefaultDispatcher
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

import dagger.Module
import dagger.Provides

@Module
object CoroutineModule {

    @Provides
    @IODispatcher
    fun provideIODispatcher(): CoroutineContext = Dispatchers.IO

    @Provides
    @DefaultDispatcher
    fun provideDefaultDispatcher(): CoroutineContext = Dispatchers.Default
}