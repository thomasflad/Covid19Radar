package com.thomasflad.covid19radar.di

import com.thomasflad.covid19radar.data.repositories.GermanyRepository
import com.thomasflad.covid19radar.domain.interfaces.IGermanyRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<IGermanyRepository> { GermanyRepository(get(), get()) }
}
