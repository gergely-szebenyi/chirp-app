package com.prekogdevs.chat.data.chat

import com.prekogdevs.chat.data.dto.websocket.WebSocketMessageDto
import com.prekogdevs.chat.data.mappers.toNewMessage
import com.prekogdevs.chat.data.network.KtorWebSocketConnector
import com.prekogdevs.chat.database.ChirpChatDatabase
import com.prekogdevs.chat.domain.chat.ChatConnectionClient
import com.prekogdevs.chat.domain.chat.ChatRepository
import com.prekogdevs.chat.domain.error.ConnectionError
import com.prekogdevs.chat.domain.message.MessageRepository
import com.prekogdevs.chat.domain.models.ChatMessage
import com.prekogdevs.chat.domain.models.ChatMessageDeliveryStatus
import com.prekogdevs.chat.domain.models.ConnectionState
import com.prekogdevs.core.domain.auth.SessionStorage
import com.prekogdevs.core.domain.util.EmptyResult
import com.prekogdevs.core.domain.util.onFailure
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.serialization.json.Json

class WebSocketChatConnectionClient(
    private val webSocketConnector: KtorWebSocketConnector,
    private val chatRepository: ChatRepository,
    private val database: ChirpChatDatabase,
    private val sessionStorage: SessionStorage,
    private val json: Json,
    private val messageRepository: MessageRepository
): ChatConnectionClient {

    override val chatMessages: Flow<ChatMessage>
        get() = TODO("Not yet implemented")

    override val connectionState = webSocketConnector.connectionState

    override suspend fun sendChatMessage(message: ChatMessage): EmptyResult<ConnectionError> {
        val outgoingDto = message.toNewMessage()
        val webSocketMessage = WebSocketMessageDto(
            type = outgoingDto.type.name,
            payload = json.encodeToString(outgoingDto)
        )
        val rawJsonPayload = json.encodeToString(webSocketMessage)

        return webSocketConnector
            .sendMessage(rawJsonPayload)
            .onFailure { error ->
                messageRepository.updateMessageDeliveryStatus(
                    messageId = message.id,
                    status = ChatMessageDeliveryStatus.FAILED
                )
            }
    }
}