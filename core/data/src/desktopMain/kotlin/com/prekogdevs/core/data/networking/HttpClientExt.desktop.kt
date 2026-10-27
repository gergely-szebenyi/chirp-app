package com.prekogdevs.core.data.networking

import com.prekogdevs.core.domain.util.DataError
import com.prekogdevs.core.domain.util.Result
import io.ktor.client.statement.HttpResponse

actual suspend fun <T> platformSafeCall(
    execute: suspend () -> HttpResponse,
    handleResponse: suspend (HttpResponse) -> Result<T, DataError.Remote>
): Result<T, DataError.Remote> {
    TODO("Not yet implemented")
}