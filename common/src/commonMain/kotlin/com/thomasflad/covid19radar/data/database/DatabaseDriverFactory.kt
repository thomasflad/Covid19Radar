package com.thomasflad.covid19radar.data.database

import com.squareup.sqldelight.db.SqlDriver

expect object DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}
