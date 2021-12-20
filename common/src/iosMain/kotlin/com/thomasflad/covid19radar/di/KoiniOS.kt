package com.thomasflad.covid19radar.di

import io.ktor.client.engine.ios.Ios
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

actual val platformModule = module {
    single { Dispatchers.Default } // Background Dispatcher
    single { Ios.create() }
}