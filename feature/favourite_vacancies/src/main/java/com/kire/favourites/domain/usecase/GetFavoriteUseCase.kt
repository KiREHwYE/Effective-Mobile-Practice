package com.kire.favourites.domain.usecase

import com.kire.favourites.domain.IFavoriteRepository
import javax.inject.Inject

/**
 * Usecase для получения списка вакансий
 *
 * @see IFavoriteRepository
 * @see IRequestResultDomain
 *
 * @return IRequestResultDomain
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
class GetFavoriteUseCase @Inject constructor(
    private val jobsRepository: IFavoriteRepository
) {
    suspend operator fun invoke() =
        jobsRepository.getFavoriteVacancies()
}