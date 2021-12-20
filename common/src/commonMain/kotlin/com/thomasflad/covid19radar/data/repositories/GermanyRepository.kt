package com.thomasflad.covid19radar.data.repositories

import com.thomasflad.covid19radar.data.localDataSource.IGermanyLocalDataSource
import com.thomasflad.covid19radar.data.remoteDataSource.IGermanyRemoteDataSource
import com.thomasflad.covid19radar.domain.cachedNetworkFlow
import com.thomasflad.covid19radar.domain.interfaces.IGermanyRepository

internal class GermanyRepository(
    private val localDataSource: IGermanyLocalDataSource,
    private val remoteDataSource: IGermanyRemoteDataSource
): IGermanyRepository {
    override fun getGermany() = cachedNetworkFlow(
        flowFromLocal = { localDataSource.getGermany() },
        fetchFromRemote = { remoteDataSource.fetchGermany() },
        saveRemoteData = { localDataSource.storeGermany(it) },
        needsRefresh = { true },
        onException = { print(it) }
    )
}