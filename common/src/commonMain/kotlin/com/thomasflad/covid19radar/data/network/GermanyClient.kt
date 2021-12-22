package com.thomasflad.covid19radar.data.network

import io.ktor.client.HttpClient
import io.ktor.client.request.get

internal class GermanyClient(private val client: HttpClient) : IGermanyClient {
    override suspend fun fetch(): GermanyResource = client.get(CoronaZahlenApi.Endpoint.Germany.path)
}
