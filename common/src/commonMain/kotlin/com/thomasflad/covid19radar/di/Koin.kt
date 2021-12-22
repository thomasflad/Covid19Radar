package com.thomasflad.covid19radar.di

import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration

expect val platformModule: Module

fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(platformModule)
    modules(networkModule)
    modules(clientModule)
    modules(databaseModule)
    modules(remoteDataSourceModule)
    modules(localDataSourceModule)
    modules(repositoryModule)
    modules(useCaseModule)
}

fun initKoin() = initKoin {}
