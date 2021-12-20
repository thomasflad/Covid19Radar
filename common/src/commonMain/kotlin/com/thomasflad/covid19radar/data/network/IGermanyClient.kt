package com.thomasflad.covid19radar.data.network

internal interface IGermanyClient {
    suspend fun fetch(): GermanyResource
}