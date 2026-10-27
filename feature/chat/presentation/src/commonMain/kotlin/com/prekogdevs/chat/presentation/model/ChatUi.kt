package com.prekogdevs.chat.presentation.model

import com.prekogdevs.chat.domain.models.ChatMessage
import com.prekogdevs.chat.domain.models.ChatParticipant
import com.prekogdevs.core.designsystem.components.avatar.ChatParticipantUi
import kotlin.time.Instant

data class ChatUi(
    val id: String,
    val localParticipant: ChatParticipantUi,
    val otherParticipants: List<ChatParticipantUi>,
    val lastMessage: ChatMessage?,
    val lastMessageSenderUsername: String?
)
