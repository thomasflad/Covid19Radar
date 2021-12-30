package com.thomasflad.covid19radar.data.database

import com.squareup.sqldelight.ColumnAdapter
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

internal inline fun <reified T : Any> jsonAdapter(): ColumnAdapter<T, String> {
    return object : ColumnAdapter<T, String> {
        override fun decode(databaseValue: String): T =
            Json.decodeFromString(databaseValue)

        override fun encode(value: T): String =
            Json.encodeToString(value)
    }
}