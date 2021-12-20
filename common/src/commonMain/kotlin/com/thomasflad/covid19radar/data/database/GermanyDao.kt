package com.thomasflad.covid19radar.data.database

import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToOneOrNull
import com.thomasflad.covid19radar.Covid19RadarDatabase
import com.thomasflad.covid19radar.GermanyEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

internal class GermanyDao(
    private val database: Covid19RadarDatabase,
    private val backgroundDispatcher: CoroutineDispatcher
) : IGermanyDao {
    override fun getGermany(): Flow<GermanyEntity?> = database.germanyEntityQueries.select()
        .asFlow()
        .mapToOneOrNull()
        .flowOn(backgroundDispatcher)

    override suspend fun insertOrReplace(entity: GermanyEntity) = withContext(backgroundDispatcher) {
        database.germanyEntityQueries.insertOrReplace(entity)
    }
}