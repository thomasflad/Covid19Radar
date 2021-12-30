package com.thomasflad.covid19radar.data.network

import com.thomasflad.covid19radar.GermanyEntity
import com.thomasflad.covid19radar.data.database.GermanyDeltaEntity
import com.thomasflad.covid19radar.data.database.GermanyHospitalizationEntity
import com.thomasflad.covid19radar.data.database.GermanyMetaEntity
import com.thomasflad.covid19radar.data.database.GermanyReproductionEntity
import com.thomasflad.covid19radar.data.database.GermanyReproductionEntity.RValue4Days
import com.thomasflad.covid19radar.data.database.GermanyReproductionEntity.RValue7Days

internal fun GermanyResource.toDatabase() = GermanyEntity(
    id = 0,
    cases = cases,
    deaths = deaths,
    recovered = recovered,
    weekIncidence = weekIncidence,
    casesPerWeek = casesPerWeek,
    casesPer100k = casesPer100k,
    hospitalization = GermanyHospitalizationEntity(
        cases7Days = hospitalization.cases7Days,
        date = hospitalization.date,
        incidence7Days = hospitalization.incidence7Days,
        lastUpdate = hospitalization.lastUpdate
    ),
    delta = GermanyDeltaEntity(
        cases = delta.cases,
        deaths = delta.deaths,
        recovered = delta.recovered
    ),
    meta = GermanyMetaEntity(
        contact = meta.contact,
        info = meta.info,
        lastCheckedForUpdate = meta.lastCheckedForUpdate,
        lastUpdate = meta.lastUpdate,
        source = meta.source
    ),
    reproduction = GermanyReproductionEntity(
        lastUpdate = reproduction.lastUpdate,
        rValue4Days = RValue4Days(
            date = reproduction.rValue4Days.date,
            value = reproduction.rValue4Days.value,
        ),
        rValue7Days = RValue7Days(
            date = reproduction.rValue7Days.date,
            value = reproduction.rValue7Days.value,
        ),
        value = reproduction.value
    )
)

