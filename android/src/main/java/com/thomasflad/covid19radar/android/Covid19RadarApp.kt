package com.thomasflad.covid19radar.android

import android.app.Application
import com.thomasflad.covid19radar.android.di.viewModelModule
import com.thomasflad.covid19radar.data.database.DatabaseDriverFactory
import com.thomasflad.covid19radar.di.initKoin
import org.koin.android.ext.koin.androidContext

class Covid19RadarApp : Application()  {
    override fun onCreate() {
        super.onCreate()

        DatabaseDriverFactory.appContext = this

        initKoin {
            modules(viewModelModule)
            androidContext(this@Covid19RadarApp)
        }
    }
}