package com.prekogdevs.chat.domain.chat

import com.prekogdevs.chat.domain.models.Chat
import com.prekogdevs.core.domain.util.DataError
import com.prekogdevs.core.domain.util.Result
import kotlinx.coroutines.flow.Flow

interface ChatRepository {
    fun getChats(): Flow<List<Chat>>
    suspend fun fetchChats(): Result<List<Chat>, DataError.Remote>
}