package com.prekogdevs.chat.domain.participant

import com.prekogdevs.chat.domain.models.ChatParticipant
import com.prekogdevs.core.domain.util.DataError
import com.prekogdevs.core.domain.util.EmptyResult
import com.prekogdevs.core.domain.util.Result

interface ChatParticipantRepository {
    suspend fun fetchLocalParticipant(): Result<ChatParticipant, DataError>
    suspend fun uploadProfilePicture(
        imageBytes: ByteArray,
        mimeType: String
    ): EmptyResult<DataError.Remote>
}