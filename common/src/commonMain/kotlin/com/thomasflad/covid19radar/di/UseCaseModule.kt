package com.thomasflad.covid19radar.di

import com.thomasflad.covid19radar.domain.useCases.GetGermany
import org.koin.dsl.module

val useCaseModule = module {
    single { GetGermany() }
}
