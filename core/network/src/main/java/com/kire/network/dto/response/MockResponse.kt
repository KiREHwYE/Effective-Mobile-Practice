package com.kire.network.dto.response

import com.kire.network.dto.response.offer.OfferResponse
import com.kire.network.dto.response.vacancy.VacancyResponse
import kotlinx.serialization.Serializable

/**
 * Содержит данные, присылаемые в mock
 *
 * @see OfferResponse
 * @see VacancyResponse
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Serializable
internal data class MockResponse(
    val offers: List<OfferResponse>,
    val vacancies: List<VacancyResponse>
)