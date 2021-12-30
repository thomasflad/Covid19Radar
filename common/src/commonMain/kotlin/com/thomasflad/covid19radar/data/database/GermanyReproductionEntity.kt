package com.thomasflad.covid19radar.data.database

import kotlinx.serialization.Serializable

@Serializable
data class GermanyReproductionEntity(
    val lastUpdate: String,
    val rValue4Days: RValue4Days,
    val rValue7Days: RValue7Days,
    val value: Double
) {
    @Serializable
    data class RValue4Days(
        val date: String,
        val value: Double
    )

    @Serializable
    data class RValue7Days(
        val date: String,
        val value: Double
    )
}