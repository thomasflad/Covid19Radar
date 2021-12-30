package com.thomasflad.covid19radar.data.database

import kotlinx.serialization.Serializable

@Serializable
data class GermanyMetaEntity(
    val contact: String,
    val info: String,
    val lastCheckedForUpdate: String,
    val lastUpdate: String,
    val source: String
)