package com.prekogdevs.chat.data.mappers

import com.prekogdevs.chat.data.dto.response.ProfilePictureUploadUrlsResponse
import com.prekogdevs.chat.domain.models.ProfilePictureUploadUrls

fun ProfilePictureUploadUrlsResponse.toDomain(): ProfilePictureUploadUrls {
    return ProfilePictureUploadUrls(
        uploadUrl = uploadUrl,
        publicUrl = publicUrl,
        headers = headers
    )
}