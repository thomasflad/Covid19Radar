package com.thomasflad.covid19radar.di

import com.thomasflad.covid19radar.data.network.GermanyClient
import com.thomasflad.covid19radar.data.network.IGermanyClient
import org.koin.dsl.module

val clientModule = module {
    single<IGermanyClient> { GermanyClient(get()) }
}
