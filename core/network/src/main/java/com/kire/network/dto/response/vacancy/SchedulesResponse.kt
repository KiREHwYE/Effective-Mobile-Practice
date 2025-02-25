package com.kire.network.dto.response.vacancy

import kotlinx.serialization.Serializable

@Serializable
data class SchedulesResponse(
    val schedules: List<String> = emptyList()
)