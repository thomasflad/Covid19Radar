package com.thomasflad.covid19radar.di

import com.thomasflad.covid19radar.data.database.GermanyDao
import com.thomasflad.covid19radar.data.database.IGermanyDao
import com.thomasflad.covid19radar.data.database.createDatabase
import org.koin.dsl.module

val databaseModule = module {
    single { createDatabase() }
    single<IGermanyDao> { GermanyDao(get(), get()) }
}