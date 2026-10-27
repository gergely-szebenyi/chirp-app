package com.prekogdevs.chat.data.chat

import com.prekogdevs.chat.data.dto.ChatParticipantDto
import com.prekogdevs.chat.data.mappers.toDomain
import com.prekogdevs.chat.domain.chat.ChatParticipantService
import com.prekogdevs.chat.domain.models.ChatParticipant
import com.prekogdevs.core.data.networking.get
import com.prekogdevs.core.domain.util.DataError
import com.prekogdevs.core.domain.util.Result
import com.prekogdevs.core.domain.util.map
import io.ktor.client.HttpClient

class KtorChatParticipantService(
    private val httpClient: HttpClient
): ChatParticipantService {

    override suspend fun searchParticipant(query: String): Result<ChatParticipant, DataError.Remote> {
        return httpClient.get<ChatParticipantDto>(
            route = "/participants",
            queryParams = mapOf(
                "query" to query
            )
        ).map { it.toDomain() }
    }
}