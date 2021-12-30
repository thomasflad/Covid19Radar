package com.thomasflad.covid19radar.data.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class GermanyResource(
    val cases: Int,
    val casesPer100k: Double,
    val casesPerWeek: Int,
    val deaths: Int,
    val delta: Delta,
    val hospitalization: Hospitalization,
    val meta: Meta,
    @SerialName("r") val reproduction: Reproduction,
    val recovered: Int,
    val weekIncidence: Double
) {
    @Serializable
    data class Delta(
        val cases: Int,
        val deaths: Int,
        val recovered: Int
    )

    @Serializable
    data class Hospitalization(
        val cases7Days: Int,
        val date: String,
        val incidence7Days: Double,
        val lastUpdate: String
    )

    @Serializable
    data class Meta(
        val contact: String,
        val info: String,
        val lastCheckedForUpdate: String,
        val lastUpdate: String,
        val source: String
    )

    @Serializable
    data class Reproduction(
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
}