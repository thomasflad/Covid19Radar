package com.thomasflad.covid19radar.data.database

import kotlinx.serialization.Serializable

@Serializable
data class GermanyHospitalizationEntity(
    val cases7Days: Int,
    val date: String,
    val incidence7Days: Double,
    val lastUpdate: String
)