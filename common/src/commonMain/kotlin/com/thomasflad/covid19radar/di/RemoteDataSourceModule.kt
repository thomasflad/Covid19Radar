package com.thomasflad.covid19radar.di

import com.thomasflad.covid19radar.data.remoteDataSource.GermanyRemoteDataSource
import com.thomasflad.covid19radar.data.remoteDataSource.IGermanyRemoteDataSource
import org.koin.dsl.module

val remoteDataSourceModule = module {
    single<IGermanyRemoteDataSource> { GermanyRemoteDataSource(get(), get()) }
}