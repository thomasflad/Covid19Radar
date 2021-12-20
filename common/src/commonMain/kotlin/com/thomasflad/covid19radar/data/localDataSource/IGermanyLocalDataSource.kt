package com.thomasflad.covid19radar.data.localDataSource

import com.thomasflad.covid19radar.domain.Germany
import kotlinx.coroutines.flow.Flow

interface IGermanyLocalDataSource {
    fun getGermany(): Flow<Germany?>
    suspend fun storeGermany(value: Germany)
}