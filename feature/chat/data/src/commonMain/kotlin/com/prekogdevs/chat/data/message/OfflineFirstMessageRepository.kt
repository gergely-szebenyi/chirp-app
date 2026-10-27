package com.prekogdevs.chat.data.message

import com.prekogdevs.chat.database.ChirpChatDatabase
import com.prekogdevs.chat.domain.message.MessageRepository
import com.prekogdevs.chat.domain.models.ChatMessageDeliveryStatus
import com.prekogdevs.core.data.database.safeDatabaseUpdate
import com.prekogdevs.core.domain.util.DataError
import com.prekogdevs.core.domain.util.EmptyResult
import kotlin.time.Clock

class OfflineFirstMessageRepository(
    private val database: ChirpChatDatabase
): MessageRepository {

    override suspend fun updateMessageDeliveryStatus(
        messageId: String,
        status: ChatMessageDeliveryStatus
    ): EmptyResult<DataError.Local> {
        return safeDatabaseUpdate {
            database.chatMessageDao.updateDeliveryStatus(
                messageId = messageId,
                status = status.name,
                timestamp = Clock.System.now().toEpochMilliseconds()
            )
        }
    }
}