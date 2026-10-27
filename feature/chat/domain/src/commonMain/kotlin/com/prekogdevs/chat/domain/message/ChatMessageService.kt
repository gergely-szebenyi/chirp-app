package com.prekogdevs.chat.domain.message

import com.prekogdevs.chat.domain.models.ChatMessage
import com.prekogdevs.core.domain.util.DataError
import com.prekogdevs.core.domain.util.Result

interface ChatMessageService {
    suspend fun fetchMessages(
        chatId: String,
        before: String? = null
    ): Result<List<ChatMessage>, DataError.Remote>
}