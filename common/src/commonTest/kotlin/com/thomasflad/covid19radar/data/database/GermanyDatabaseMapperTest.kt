package com.thomasflad.covid19radar.data.database

import com.thomasflad.covid19radar.GermanyEntity
import com.thomasflad.covid19radar.domain.Germany
import kotlin.test.Test
import kotlin.test.assertEquals

@Suppress("IllegalIdentifier")
class GermanyDatabaseMapperTest {

    @Test
    fun `toDomain should map database entity`() {

        val actual = GermanyEntity(
            id = 1,
            cases = 2,
            deaths = 3,
            recovered = 4,
            weekIncidence = 5,
            casesPerWeek = 6,
            casesPer100k = 7
        ).toDomain()

        val expected = Germany(
            cases = 2,
            deaths = 3,
            recovered = 4,
            weekIncidence = 5,
            casesPerWeek = 6,
            casesPer100k = 7
        )

        assertEquals(expected, actual)
    }
}
