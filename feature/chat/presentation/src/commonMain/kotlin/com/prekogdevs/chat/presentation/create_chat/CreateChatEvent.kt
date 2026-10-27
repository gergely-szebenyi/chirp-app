package com.prekogdevs.chat.presentation.create_chat

import com.prekogdevs.chat.domain.models.Chat

sealed interface CreateChatEvent {
    data class OnChatCreated(val chat: Chat): CreateChatEvent
}