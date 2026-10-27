package com.prekogdevs.chat.domain.notification

import com.prekogdevs.core.domain.util.DataError
import com.prekogdevs.core.domain.util.EmptyResult
import com.prekogdevs.core.domain.util.Result

interface DeviceTokenService {

    suspend fun registerToken(
        token: String,
        platform: String
    ): EmptyResult<DataError.Remote>

    suspend fun unregisterToken(
        token: String
    ): EmptyResult<DataError.Remote>
}