package com.prekogdevs.chat.data.di

import com.prekogdevs.chat.data.lifecycle.AppLifecycleObserver
import com.prekogdevs.chat.data.network.ConnectionErrorHandler
import com.prekogdevs.chat.data.network.ConnectivityObserver
import com.prekogdevs.chat.database.DatabaseFactory
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual val platformChatDataModule = module {
    single { DatabaseFactory(androidContext()) }
    singleOf(::AppLifecycleObserver)
    singleOf(::ConnectivityObserver)
    singleOf(::ConnectionErrorHandler)
}