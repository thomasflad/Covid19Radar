package com.thomasflad.covid19radar.data.database

import com.thomasflad.covid19radar.GermanyEntity
import com.thomasflad.covid19radar.domain.Germany

internal fun GermanyEntity.toDomain() = Germany(
    weekIncidence = weekIncidence,
    hospitalizationIncidence = hospitalization.incidence7Days
)
