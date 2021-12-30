package com.thomasflad.covid19radar.domain

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart

data class DataState<out T>(
    val status: Status,
    val data: T?,
    val message: String?
) {

    enum class Status {
        INITIAL, LOADING, SUCCESS, ERROR
    }

    companion object {
        fun <T> initial(): DataState<T> =
            DataState(
                status = Status.INITIAL,
                data = null,
                message = null
            )

        fun <T> loading(data: T? = null): DataState<T> =
            DataState(
                status = Status.LOADING,
                data = data,
                message = null
            )

        fun <T> success(data: T?): DataState<T> =
            DataState(
                status = Status.SUCCESS,
                data = data,
                message = null
            )

        fun <T> error(
            data: T? = null,
            message: String? = null
        ): DataState<T> =
            DataState(
                status = Status.ERROR,
                data = data,
                message = message
            )
    }
}

inline fun <REMOTE, DATABASE, DOMAIN> cachedNetworkFlow(
    crossinline flowFromLocal: () -> Flow<DATABASE?>,
    crossinline fetchFromRemote: suspend () -> REMOTE,
    crossinline saveRemoteData: suspend (REMOTE) -> Unit,
    crossinline needsRefresh: (DATABASE?) -> Boolean = { false },
    crossinline mapper: (DATABASE?) -> DOMAIN?,
    crossinline onException: (Throwable) -> Unit = {}
) = flow<DataState<DOMAIN>> {

    emit(DataState.loading())

    val currentValue = flowFromLocal().first()

    flowFromLocal()
        .onStart {
            if (needsRefresh(currentValue)) {
                emit(DataState.loading(mapper(currentValue)))
                saveRemoteData(fetchFromRemote())
            }
        }
        .catch {
            emit(DataState.error(mapper(currentValue), it.message))
            onException(it)
        }
        .collect { emit(DataState.success(mapper(it))) }
}
