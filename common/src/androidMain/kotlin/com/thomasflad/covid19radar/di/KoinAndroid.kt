package com.thomasflad.covid19radar.di

import io.ktor.client.engine.okhttp.OkHttp
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

actual val platformModule = module {
    single { Dispatchers.IO } // Background Dispatcher
    single { OkHttp.create() }
}