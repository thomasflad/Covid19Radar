package com.thomasflad.covid19radar.data.remoteDataSource

import com.thomasflad.covid19radar.domain.Germany
import com.thomasflad.covid19radar.data.network.IGermanyClient
import com.thomasflad.covid19radar.data.network.toDomain
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

internal class GermanyRemoteDataSource(
    private val client: IGermanyClient,
    private val backgroundDispatcher: CoroutineDispatcher
) : IGermanyRemoteDataSource {
    override suspend fun fetchGermany(): Germany = withContext(backgroundDispatcher) {
        client.fetch().toDomain()
    }
}