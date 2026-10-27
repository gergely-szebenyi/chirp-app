package com.prekogdevs.chat.data.mappers

import com.prekogdevs.chat.data.dto.ChatParticipantDto
import com.prekogdevs.chat.domain.models.ChatParticipant

fun ChatParticipantDto.toDomain(): ChatParticipant {
    return ChatParticipant(
        userId = userId,
        username = username,
        profilePictureUrl = profilePictureUrl
    )
}