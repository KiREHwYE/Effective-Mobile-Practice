package com.kire.favourites.di

import com.kire.favourites.data.FavoriteRepository
import com.kire.favourites.domain.IFavoriteRepository
import com.kire.favourites.domain.usecase.FavoriteUseCases
import com.kire.favourites.domain.usecase.GetFavoriteUseCase
import com.kire.favourites.domain.usecase.IFavoriteUseCases
import com.kire.network.api.IApiService
import com.kire.util.IODispatcher

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher

/**
 * Отвечает за инжекцию зависимостей в рамках feature:favorite_vacancies
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Module
class FavoriteModule {

    /**
     * Отвечает за создание FavoriteRepository
     *
     * @param apiService для работы с API
     * @param coroutineDispatcher поток выполнения корутины
     *
     * @see IFavoriteRepository
     *
     * @return FavoriteRepository
     *
     * @author Михаил Гонтарев (KiREHwYE)
     */
    @Provides
    fun provideJobsRepository(
        apiService: IApiService,
        @IODispatcher coroutineDispatcher: CoroutineDispatcher
    ): IFavoriteRepository {
        return FavoriteRepository(apiService, coroutineDispatcher)
    }

    /**
     * Отвечает за создание FavoriteUseCases
     *
     * @param getFavoriteUseCase usecase для получения избранных вакансий
     *
     * @see IFavoriteUseCases
     *
     * @return IFavoriteUseCases
     *
     * @author Михаил Гонтарев (KiREHwYE)
     */
    @Provides
    fun provideFavoriteUseCases(
        getFavoriteUseCase: GetFavoriteUseCase
    ): IFavoriteUseCases {
        return FavoriteUseCases(getFavoriteUseCase)
    }

    /**
     * Отвечает за создание GetFavoriteUseCase
     *
     * @param favoriteRepository репозиторий для работы с избранными вакансиями
     *
     * @see GetFavoriteUseCase
     * @see IFavoriteRepository
     *
     * @return GetFavoriteUseCase
     *
     * @author Михаил Гонтарев (KiREHwYE)
     */
    @Provides
    fun provideGetFavoriteUseCase(favoriteRepository: IFavoriteRepository): GetFavoriteUseCase {
        return GetFavoriteUseCase(favoriteRepository)
    }


    /**
     * Отвечает за создание provideJobsViewModelFactory
     *
     * @param jobsUseCases usecase'ы экранов feature:jobs
     *
     * @see IJobsUseCases
     * @see JobsViewModelFactory
     *
     * @author Михаил Гонтарев (KiREHwYE)
     */
    @Provides
    fun provideFavoriteViewModelFactory(favoriteUseCases: IFavoriteUseCases): FavoriteViewModelFactory {
        return FavoriteViewModelFactory(favoriteUseCases)
    }
}