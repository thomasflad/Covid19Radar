package com.thomasflad.covid19radar.domain

data class Germany(
    val cases: Double,
    val deaths: Double,
    val recovered: Double,
    val weekIncidence: Double,
    val casesPerWeek: Double,
    val casesPer100k: Double
)
