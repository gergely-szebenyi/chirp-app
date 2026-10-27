package com.prekogdevs.core.data.mappers

import com.prekogdevs.core.data.dto.AuthInfoSerializable
import com.prekogdevs.core.data.dto.UserSerializable
import com.prekogdevs.core.domain.auth.AuthInfo
import com.prekogdevs.core.domain.auth.User

fun AuthInfoSerializable.toDomain(): AuthInfo {
    return AuthInfo(
        accessToken = accessToken,
        refreshToken = refreshToken,
        user = user.toDomain()
    )
}

fun UserSerializable.toDomain(): User {
    return User(
        id = id,
        email = email,
        username = username,
        hasVerifiedEmail = hasVerifiedEmail,
        profilePictureUrl = profilePictureUrl
    )
}