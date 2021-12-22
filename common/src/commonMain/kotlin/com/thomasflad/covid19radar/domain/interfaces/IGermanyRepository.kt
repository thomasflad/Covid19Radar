package com.thomasflad.covid19radar.domain.interfaces

import com.thomasflad.covid19radar.domain.DataState
import com.thomasflad.covid19radar.domain.Germany
import kotlinx.coroutines.flow.Flow

interface IGermanyRepository {
    fun getGermany(): Flow<DataState<Germany>>
}
