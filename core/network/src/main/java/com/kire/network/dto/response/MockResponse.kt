package com.kire.network.dto.response

import com.kire.network.dto.response.offer.OfferResponse
import com.kire.network.dto.response.vacancy.VacancyResponse
import kotlinx.serialization.Serializable

@Serializable
data class MockResponse(
    val offers: List<OfferResponse>,
    val vacancies: List<VacancyResponse>
)