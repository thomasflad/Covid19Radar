package com.thomasflad.covid19radar.data.network

import com.thomasflad.covid19radar.domain.Germany

internal fun GermanyResource.toDomain() = Germany(
    cases = cases,
    deaths = deaths,
    recovered = recovered,
    weekIncidence = weekIncidence,
    casesPerWeek = casesPerWeek,
    casesPer100k = casesPer100k
)
