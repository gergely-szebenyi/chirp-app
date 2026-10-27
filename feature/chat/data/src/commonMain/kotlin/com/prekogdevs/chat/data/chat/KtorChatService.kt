package com.prekogdevs.chat.data.chat

import com.prekogdevs.chat.data.dto.ChatDto
import com.prekogdevs.chat.data.dto.request.CreateChatRequest
import com.prekogdevs.chat.data.mappers.toDomain
import com.prekogdevs.chat.domain.chat.ChatService
import com.prekogdevs.chat.domain.models.Chat
import com.prekogdevs.core.data.networking.get
import com.prekogdevs.core.data.networking.post
import com.prekogdevs.core.domain.util.DataError
import com.prekogdevs.core.domain.util.Result
import com.prekogdevs.core.domain.util.map
import io.ktor.client.HttpClient

class KtorChatService(
    private val httpClient: HttpClient
): ChatService {

    override suspend fun createChat(otherUserIds: List<String>): Result<Chat, DataError.Remote> {
        return httpClient.post<CreateChatRequest, ChatDto>(
            route = "/chat",
            body = CreateChatRequest(
                otherUserIds = otherUserIds
            )
        ).map { it.toDomain() }
    }

    override suspend fun getChats(): Result<List<Chat>, DataError.Remote> {
        return httpClient.get<List<ChatDto>>(
            route = "/chat"
        ).map { chatDtos ->
            chatDtos.map { it.toDomain() }
        }
    }
}