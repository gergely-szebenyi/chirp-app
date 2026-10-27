package com.prekogdevs.chat.domain.participant

import com.prekogdevs.chat.domain.models.ChatParticipant
import com.prekogdevs.core.domain.util.DataError
import com.prekogdevs.core.domain.util.Result

interface ChatParticipantService {
    suspend fun searchParticipant(
        query: String
    ): Result<ChatParticipant, DataError.Remote>

    suspend fun getLocalParticipant(): Result<ChatParticipant, DataError.Remote>
}