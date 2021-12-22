package com.thomasflad.covid19radar.di

import com.thomasflad.covid19radar.data.localDataSource.GermanyLocalDataSource
import com.thomasflad.covid19radar.data.localDataSource.IGermanyLocalDataSource
import org.koin.dsl.module

val localDataSourceModule = module {
    single<IGermanyLocalDataSource> { GermanyLocalDataSource(get()) }
}
