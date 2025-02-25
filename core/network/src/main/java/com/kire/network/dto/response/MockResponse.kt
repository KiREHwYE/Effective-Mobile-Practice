package com.kire.network.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class MockResponse(
    val offers: List<Offer>,
    val vacancies: List<Vacancy>
)