package com.prekogdevs.chat.presentation.mappers

import com.prekogdevs.chat.domain.models.ChatParticipant
import com.prekogdevs.core.designsystem.components.avatar.ChatParticipantUi

fun ChatParticipant.toUi(): ChatParticipantUi {
    return ChatParticipantUi(
        id = userId,
        username = username,
        initials = initials,
        imageUrl = profilePictureUrl
    )
}