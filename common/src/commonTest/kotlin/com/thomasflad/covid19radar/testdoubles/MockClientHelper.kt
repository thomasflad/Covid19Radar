package com.thomasflad.covid19radar.testdoubles

import co.touchlab.stately.concurrency.AtomicReference
import co.touchlab.stately.freeze
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.plugins.ContentNegotiation
import io.ktor.http.ContentType.Application
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class MockClientHelper {

    private var responseListRef: AtomicReference<List<MockResponse>> =
        AtomicReference(emptyList<MockResponse>().freeze())

    fun clientEngine() = client().engine

    fun enqueueResponse(mockResponse: MockResponse) {
        val new = responseListRef.get().plus(mockResponse)
        responseListRef.set(new.freeze())
    }

    private fun client() = HttpClient(MockEngine) {
        engine {
            addHandler {
                val response = responseListRef.consumeResponse()
                val headers = headersOf("Content-Type" to listOf(Application.Json.toString()))
                respond(response.body, response.statusCode, headers)
            }
        }
    }

    private fun AtomicReference<List<MockResponse>>.consumeResponse(): MockResponse =
        if (get().isEmpty())
            throw IllegalStateException("Please enqueue the missing responses")
        else get().first().also { set(get().drop(1)) }
}

internal fun createTestHttpClient(clientEngine: HttpClientEngine) = HttpClient(clientEngine) {
    install(ContentNegotiation) {
        val json = Json {
            isLenient = true
            ignoreUnknownKeys = true
        }
        json(json)
    }
}

class MockResponse(val body: String = "", val statusCode: HttpStatusCode = HttpStatusCode.OK)

internal inline fun <reified T> respondOK(content: T) =
    MockResponse(Json.encodeToString(content), HttpStatusCode.OK)

internal fun respondError(statusCode: HttpStatusCode = HttpStatusCode.Forbidden) =
    MockResponse("", statusCode)
