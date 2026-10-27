package com.prekogdevs.chat.data.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.prekogdevs.chat.data.chat.KtorChatParticipantService
import com.prekogdevs.chat.data.chat.KtorChatService
import com.prekogdevs.chat.data.chat.OfflineFirstChatRepository
import com.prekogdevs.chat.data.chat.WebSocketChatConnectionClient
import com.prekogdevs.chat.data.lifecycle.AppLifecycleObserver
import com.prekogdevs.chat.data.message.OfflineFirstMessageRepository
import com.prekogdevs.chat.data.network.KtorWebSocketConnector
import com.prekogdevs.chat.database.DatabaseFactory
import com.prekogdevs.chat.domain.chat.ChatConnectionClient
import com.prekogdevs.chat.domain.chat.ChatParticipantService
import com.prekogdevs.chat.domain.chat.ChatRepository
import com.prekogdevs.chat.domain.chat.ChatService
import com.prekogdevs.chat.domain.message.MessageRepository
import kotlinx.serialization.json.Json
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformChatDataModule: Module

val chatDataModule = module {
    includes(platformChatDataModule)

    singleOf(::KtorChatParticipantService) bind ChatParticipantService::class
    singleOf(::KtorChatService) bind ChatService::class
    singleOf(::OfflineFirstChatRepository) bind ChatRepository::class
    singleOf(::OfflineFirstMessageRepository) bind MessageRepository::class
    singleOf(::WebSocketChatConnectionClient) bind ChatConnectionClient::class
    singleOf(::KtorWebSocketConnector)
    single {
        Json {
            ignoreUnknownKeys = true
        }
    }
    single {
        get<DatabaseFactory>()
            .create()
            .setDriver(BundledSQLiteDriver())
            .build()
    }
}