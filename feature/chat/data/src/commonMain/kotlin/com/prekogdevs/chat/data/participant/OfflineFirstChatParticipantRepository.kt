package com.prekogdevs.chat.data.participant

import com.prekogdevs.chat.domain.models.ChatParticipant
import com.prekogdevs.chat.domain.participant.ChatParticipantRepository
import com.prekogdevs.chat.domain.participant.ChatParticipantService
import com.prekogdevs.core.domain.auth.AuthInfo
import com.prekogdevs.core.domain.auth.SessionStorage
import com.prekogdevs.core.domain.util.DataError
import com.prekogdevs.core.domain.util.Result
import com.prekogdevs.core.domain.util.onSuccess
import kotlinx.coroutines.flow.first

class OfflineFirstChatParticipantRepository(
    private val sessionStorage: SessionStorage,
    private val chatParticipantService: ChatParticipantService
): ChatParticipantRepository {

    override suspend fun fetchLocalParticipant(): Result<ChatParticipant, DataError> {
        return chatParticipantService
            .getLocalParticipant()
            .onSuccess { participant ->
                val currentAuthInfo = sessionStorage.observeAuthInfo().first()
                sessionStorage.set(
                    currentAuthInfo?.copy(
                        user = currentAuthInfo.user.copy(
                            id = participant.userId,
                            username = participant.username,
                            profilePictureUrl = participant.profilePictureUrl
                        )
                    )
                )
            }
    }
}