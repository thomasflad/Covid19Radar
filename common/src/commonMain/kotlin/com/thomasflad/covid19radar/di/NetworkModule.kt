package com.thomasflad.covid19radar.di

import com.thomasflad.covid19radar.data.network.createHttpClient
import org.koin.dsl.module

val networkModule = module {
    single { createHttpClient(get()) }
}
