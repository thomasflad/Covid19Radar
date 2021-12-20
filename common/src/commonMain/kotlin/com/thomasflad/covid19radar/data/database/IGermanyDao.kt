package com.thomasflad.covid19radar.data.database

import com.thomasflad.covid19radar.GermanyEntity
import kotlinx.coroutines.flow.Flow

internal interface IGermanyDao {
    fun getGermany(): Flow<GermanyEntity?>
    suspend fun insertOrReplace(entity: GermanyEntity)
}