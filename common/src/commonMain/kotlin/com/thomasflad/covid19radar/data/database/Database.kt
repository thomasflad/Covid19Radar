package com.thomasflad.covid19radar.data.database

import com.thomasflad.covid19radar.Covid19RadarDatabase

fun createDatabase(): Covid19RadarDatabase {
    return Covid19RadarDatabase(DatabaseDriverFactory.createDriver())
}