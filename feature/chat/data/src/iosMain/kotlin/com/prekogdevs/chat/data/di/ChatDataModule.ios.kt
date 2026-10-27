package com.prekogdevs.chat.data.di

import com.prekogdevs.chat.data.lifecycle.AppLifecycleObserver
import com.prekogdevs.chat.database.DatabaseFactory
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual val platformChatDataModule = module {
    single { DatabaseFactory() }
    singleOf(::AppLifecycleObserver)
}