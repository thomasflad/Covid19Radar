package com.thomasflad.covid19radar

import com.thomasflad.covid19radar.data.database.IGermanyDao
import com.thomasflad.covid19radar.di.clientModule
import com.thomasflad.covid19radar.di.localDataSourceModule
import com.thomasflad.covid19radar.di.repositoryModule
import com.thomasflad.covid19radar.testdoubles.FakeGermanyDao
import com.thomasflad.covid19radar.testdoubles.MockClientHelper
import com.thomasflad.covid19radar.testdoubles.createTestHttpClient
import io.ktor.client.engine.HttpClientEngine
import kotlinx.coroutines.Dispatchers
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoinTest(
    clientEngine: HttpClientEngine = MockClientHelper().clientEngine(),
    declaration: KoinAppDeclaration = {}
) = startKoin {
    modules(
        module {
            single { Dispatchers.Unconfined } // Background Dispatcher
            single { createTestHttpClient(clientEngine) }
            single<IGermanyDao> { FakeGermanyDao() }
        }
    )
    modules(clientModule)
    modules(repositoryModule)
    modules(localDataSourceModule)
    modules(repositoryModule)
    declaration()
}
