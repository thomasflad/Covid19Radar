package com.thomasflad.covid19radar.testdoubles

import com.thomasflad.covid19radar.GermanyEntity
import com.thomasflad.covid19radar.data.database.IGermanyDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

internal class FakeGermanyDao : IGermanyDao {
    private var flow = MutableStateFlow<GermanyEntity?>(null)
    override fun getGermany(): Flow<GermanyEntity?> = flow
    override suspend fun insertOrReplace(entity: GermanyEntity) {
        flow.value = entity
    }
}
