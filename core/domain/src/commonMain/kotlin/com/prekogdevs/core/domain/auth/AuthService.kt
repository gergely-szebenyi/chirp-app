package com.prekogdevs.core.domain.auth

import com.prekogdevs.core.domain.util.DataError
import com.prekogdevs.core.domain.util.EmptyResult

interface AuthService {
    suspend fun register(
        email: String,
        username: String,
        password: String
    ): EmptyResult<DataError.Remote>
}