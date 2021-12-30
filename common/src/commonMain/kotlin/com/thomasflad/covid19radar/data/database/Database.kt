package com.thomasflad.covid19radar.data.database

import com.thomasflad.covid19radar.Covid19RadarDatabase
import com.thomasflad.covid19radar.GermanyEntity

fun createDatabase(): Covid19RadarDatabase {
    return Covid19RadarDatabase(
        driver = DatabaseDriverFactory.createDriver(),
        GermanyEntityAdapter = GermanyEntity.Adapter(
            deltaAdapter = jsonAdapter(),
            reproductionAdapter = jsonAdapter(),
            hospitalizationAdapter = jsonAdapter(),
            metaAdapter = jsonAdapter()
        ),
    )
}
