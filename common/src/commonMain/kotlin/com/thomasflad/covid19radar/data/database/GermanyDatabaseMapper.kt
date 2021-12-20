package com.thomasflad.covid19radar.data.database

import com.thomasflad.covid19radar.GermanyEntity
import com.thomasflad.covid19radar.domain.Germany

internal fun GermanyEntity.toDomain() = Germany(
    cases = cases,
    deaths = deaths,
    recovered = recovered,
    weekIncidence = weekIncidence,
    casesPerWeek = casesPerWeek,
    casesPer100k = casesPer100k
)

internal fun Germany.toDatabase() = GermanyEntity(
    id = 0,
    cases = cases,
    deaths = deaths,
    recovered = recovered,
    weekIncidence = weekIncidence,
    casesPerWeek = casesPerWeek,
    casesPer100k = casesPer100k
)

