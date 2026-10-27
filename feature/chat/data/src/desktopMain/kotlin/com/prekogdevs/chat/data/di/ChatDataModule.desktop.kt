package com.prekogdevs.chat.data.di

import com.prekogdevs.chat.data.lifecycle.AppLifecycleObserver
import com.prekogdevs.chat.data.network.ConnectionErrorHandler
import com.prekogdevs.chat.data.network.ConnectivityObserver
import com.prekogdevs.chat.data.notification.DesktopNotifier
import com.prekogdevs.chat.data.notification.FirebasePushNotificationService
import com.prekogdevs.chat.database.DatabaseFactory
import com.prekogdevs.chat.domain.notification.PushNotificationService
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

actual val platformChatDataModule = module {
    singleOf(::DatabaseFactory)
    singleOf(::ConnectionErrorHandler)
    singleOf(::ConnectivityObserver)
    singleOf(::AppLifecycleObserver)
    singleOf(::DesktopNotifier)
    singleOf(::FirebasePushNotificationService) bind PushNotificationService::class
}