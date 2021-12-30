package com.thomasflad.covid19radar.data.repositories

import co.touchlab.kermit.Logger
import com.thomasflad.covid19radar.data.database.IGermanyDao
import com.thomasflad.covid19radar.data.database.toDomain
import com.thomasflad.covid19radar.data.network.IGermanyClient
import com.thomasflad.covid19radar.data.network.toDatabase
import com.thomasflad.covid19radar.domain.cachedNetworkFlow
import com.thomasflad.covid19radar.domain.interfaces.IGermanyRepository

internal class GermanyRepository(
    private val dao: IGermanyDao,
    private val client: IGermanyClient
) : IGermanyRepository {
    override fun getGermany() = cachedNetworkFlow(
        flowFromLocal = { dao.getGermany() },
        fetchFromRemote = { client.fetch() },
        saveRemoteData = { dao.insertOrReplace(it.toDatabase()) },
        needsRefresh = { true },
        mapper = { it?.toDomain() },
        onException = { Logger.w(it) { "Error on GetGermany" } }
    )
}
