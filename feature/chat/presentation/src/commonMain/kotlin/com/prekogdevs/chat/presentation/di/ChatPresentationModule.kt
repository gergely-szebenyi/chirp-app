package com.prekogdevs.chat.presentation.di

import com.prekogdevs.chat.presentation.chat_detail.ChatDetailViewModel
import com.prekogdevs.chat.presentation.chat_list.ChatListViewModel
import com.prekogdevs.chat.presentation.chat_list_detail.ChatListDetailViewModel
import com.prekogdevs.chat.presentation.create_chat.CreateChatViewModel
import com.prekogdevs.chat.presentation.manage_chat.ManageChatViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val chatPresentationModule = module {
    viewModelOf(::ChatListViewModel)
    viewModelOf(::ChatListDetailViewModel)
    viewModelOf(::CreateChatViewModel)
    viewModelOf(::ChatDetailViewModel)
    viewModelOf(::ManageChatViewModel)
}