package com.prekogdevs.chat.data.mappers

import com.prekogdevs.chat.data.dto.ChatMessageDto
import com.prekogdevs.chat.domain.models.ChatMessage
import kotlin.time.Instant

fun ChatMessageDto.toDomain(): ChatMessage {
    return ChatMessage(
        id = id,
        chatId = chatId,
        content = content,
        createdAt = Instant.parse(createdAt),
        senderId = senderId
    )
}