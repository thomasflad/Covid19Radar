package com.thomasflad.covid19radar.data.network

import kotlinx.serialization.Serializable

@Serializable
internal data class GermanyResource(
    val cases: Double,
    val deaths: Double,
    val recovered: Double,
    val weekIncidence: Double,
    val casesPerWeek: Double,
    val casesPer100k: Double
)
