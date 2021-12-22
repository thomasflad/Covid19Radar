package com.thomasflad.covid19radar.domain.useCases

import app.cash.turbine.test
import com.thomasflad.covid19radar.GermanyEntity
import com.thomasflad.covid19radar.data.database.IGermanyDao
import com.thomasflad.covid19radar.data.database.toDomain
import com.thomasflad.covid19radar.initKoinTest
import kotlinx.coroutines.test.runTest
import org.koin.test.KoinTest
import org.koin.test.inject
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

@Suppress("IllegalIdentifier")
class GetGermanyTest : KoinTest {

    private val dao: IGermanyDao by inject()

    @BeforeTest
    fun setup() {
        initKoinTest()
    }

    @Test
    fun `invoke should return flow of entities`() = runTest {
        val entity = GermanyEntity(
            id = 0,
            cases = 0,
            deaths = 0,
            recovered = 0,
            weekIncidence = 0,
            casesPerWeek = 0,
            casesPer100k = 0
        )

        dao.insertOrReplace(entity)

        val cut = GetGermany()

        cut().test {
            assertEquals(entity.toDomain(), awaitItem())
        }
    }
}
