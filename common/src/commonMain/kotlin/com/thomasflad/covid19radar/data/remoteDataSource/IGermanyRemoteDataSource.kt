package com.thomasflad.covid19radar.data.remoteDataSource

import com.thomasflad.covid19radar.domain.Germany

interface IGermanyRemoteDataSource {
    suspend fun fetchGermany(): Germany
}
