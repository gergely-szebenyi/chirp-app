package com.prekogdevs.chat.domain.chat

import com.prekogdevs.chat.domain.error.ConnectionError
import com.prekogdevs.chat.domain.models.ChatMessage
import com.prekogdevs.chat.domain.models.ConnectionState
import com.prekogdevs.core.domain.util.EmptyResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface ChatConnectionClient {
    val chatMessages: Flow<ChatMessage>
    val connectionState: StateFlow<ConnectionState>
    suspend fun sendChatMessage(message: ChatMessage): EmptyResult<ConnectionError>
}