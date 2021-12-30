package com.thomasflad.covid19radar.domain.useCases

import app.cash.turbine.test
import com.thomasflad.covid19radar.data.database.toDomain
import com.thomasflad.covid19radar.data.network.GermanyResource
import com.thomasflad.covid19radar.data.network.GermanyResource.Delta
import com.thomasflad.covid19radar.data.network.GermanyResource.Hospitalization
import com.thomasflad.covid19radar.data.network.GermanyResource.Meta
import com.thomasflad.covid19radar.data.network.GermanyResource.Reproduction
import com.thomasflad.covid19radar.data.network.GermanyResource.Reproduction.RValue4Days
import com.thomasflad.covid19radar.data.network.GermanyResource.Reproduction.RValue7Days
import com.thomasflad.covid19radar.data.network.toDatabase
import com.thomasflad.covid19radar.domain.DataState.Status.LOADING
import com.thomasflad.covid19radar.domain.DataState.Status.SUCCESS
import com.thomasflad.covid19radar.initKoinTest
import com.thomasflad.covid19radar.testdoubles.MockClientHelper
import com.thomasflad.covid19radar.testdoubles.respondOK
import kotlinx.coroutines.runBlocking
import org.koin.test.KoinTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

@Suppress("IllegalIdentifier")
class GetGermanyTest : KoinTest {

    private val mockClientHelper = MockClientHelper()

    @BeforeTest
    fun setup() {
        initKoinTest(clientEngine = mockClientHelper.clientEngine())
    }

    @Test
    fun `dataFlow should return flow of entities`() = runBlocking {
        val resource = GermanyResource(
            cases = 0,
            deaths = 0,
            recovered = 0,
            weekIncidence = 0.0,
            casesPerWeek = 0,
            casesPer100k = 0.0,
            delta = Delta(
                cases = 0,
                deaths = 0,
                recovered = 0,
            ),
            hospitalization = Hospitalization(
                cases7Days = 0,
                date = "",
                incidence7Days = 0.0,
                lastUpdate = "",
            ),
            meta = Meta(
                contact = "",
                info = "",
                lastCheckedForUpdate = "",
                lastUpdate = "",
                source = "",
            ),
            reproduction = Reproduction(
                lastUpdate = "",
                rValue4Days = RValue4Days(
                    date = "",
                    value = 0.0
                ),
                rValue7Days = RValue7Days(
                    date = "",
                    value = 0.0
                ),
                value = 0.0,
            ),
        )

        mockClientHelper.enqueueResponse(mockResponse = respondOK(resource))

        val cut = GetGermany()

        cut.dataFlow().test {
            assertEquals(LOADING, awaitItem().status)
            assertEquals(LOADING, awaitItem().status)
            awaitItem().also {
                assertEquals(SUCCESS, it.status)
                assertEquals(resource.toDatabase().toDomain(), it.data)
            }
        }

    }
}
