package com.prekogdevs.chat.domain.chat

import com.prekogdevs.chat.domain.models.Chat
import com.prekogdevs.core.domain.util.DataError
import com.prekogdevs.core.domain.util.Result

interface ChatService {
    suspend fun createChat(
        otherUserIds: List<String>
    ): Result<Chat, DataError.Remote>

    suspend fun getChats(): Result<List<Chat>, DataError.Remote>
}