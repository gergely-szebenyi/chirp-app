package com.prekogdevs.chat.domain.chat

import com.prekogdevs.chat.domain.models.ChatMessage
import com.prekogdevs.chat.domain.models.ConnectionState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface ChatConnectionClient {
    val chatMessages: Flow<ChatMessage>
    val connectionState: StateFlow<ConnectionState>
}