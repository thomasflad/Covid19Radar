package com.thomasflad.covid19radar.data.database

import kotlinx.serialization.Serializable

@Serializable
data class GermanyDeltaEntity(
    val cases: Int,
    val deaths: Int,
    val recovered: Int
)