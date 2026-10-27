package com.prekogdevs.chat.presentation.chat_list

import com.prekogdevs.core.presentation.util.UiText

sealed interface ChatListEvent {
    data object OnLogoutSuccess: ChatListEvent
    data class OnLogoutError(val error: UiText): ChatListEvent
}