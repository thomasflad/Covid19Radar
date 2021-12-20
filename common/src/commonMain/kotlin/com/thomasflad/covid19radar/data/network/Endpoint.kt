package com.thomasflad.covid19radar.data.network

internal object Api {

    internal sealed class Endpoint(val path: String) {
        object Germany : Endpoint(ENDPOINT_URL + GERMANY_PATH)
    }

    private const val SCHEME = "https"
    private const val HOST = "api.corona-zahlen.org"
    private const val PORT = "443"
    const val ENDPOINT_URL = "$SCHEME://$HOST:$PORT"
    const val GERMANY_PATH = "/germany"

}