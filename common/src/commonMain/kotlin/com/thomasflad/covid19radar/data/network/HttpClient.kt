package com.thomasflad.covid19radar.data.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.features.HttpTimeout
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.DEFAULT
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging
import kotlinx.serialization.json.Json

fun createHttpClient(clientEngine: HttpClientEngine) = HttpClient(clientEngine) {

    install(JsonFeature) {
        val json = Json {
            ignoreUnknownKeys = true
            prettyPrint = true
            isLenient = true
        }
        serializer = KotlinxSerializer(json)
    }

    install(HttpTimeout) {
        socketTimeoutMillis = 10000L
        connectTimeoutMillis = 10000L
        requestTimeoutMillis = 10000L
    }

    install(Logging) {
        logger = Logger.DEFAULT
        level = LogLevel.INFO
    }

}