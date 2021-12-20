package com.thomasflad.covid19radar.android.di

import com.thomasflad.covid19radar.android.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainActivityViewModel(get()) }
}