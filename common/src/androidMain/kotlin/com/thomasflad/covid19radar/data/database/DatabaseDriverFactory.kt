package com.thomasflad.covid19radar.data.database

import android.content.Context
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import com.thomasflad.covid19radar.Covid19RadarDatabase

actual object DatabaseDriverFactory {
    lateinit var appContext: Context

    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(Covid19RadarDatabase.Schema, appContext, "covid19radar.db")
    }
}