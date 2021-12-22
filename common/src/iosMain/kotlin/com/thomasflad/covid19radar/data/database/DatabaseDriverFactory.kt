package com.thomasflad.covid19radar.data.database

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import com.thomasflad.covid19radar.Covid19RadarDatabase

actual object DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(Covid19RadarDatabase.Schema, "covid19radar.db")
    }
}
