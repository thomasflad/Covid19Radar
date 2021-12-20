package com.thomasflad.covid19radar.data.localDataSource

import com.thomasflad.covid19radar.data.database.IGermanyDao
import com.thomasflad.covid19radar.data.database.toDatabase
import com.thomasflad.covid19radar.data.database.toDomain
import com.thomasflad.covid19radar.domain.Germany
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class GermanyLocalDataSource(
    private val dao: IGermanyDao
) : IGermanyLocalDataSource {
    override fun getGermany(): Flow<Germany?> = dao.getGermany()
        .map { it?.toDomain() }

    override suspend fun storeGermany(value: Germany) {
        dao.insertOrReplace(value.toDatabase())
    }
}