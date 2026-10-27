package com.prekogdevs.chirp.di

import com.prekogdevs.auth.presentation.di.authPresentationModule
import com.prekogdevs.chat.data.di.chatDataModule
import com.prekogdevs.chat.presentation.di.chatPresentationModule
import com.prekogdevs.core.data.di.coreDataModule
import com.prekogdevs.core.presentation.di.corePresentationModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(
            coreDataModule,
            authPresentationModule,
            appModule,
            chatPresentationModule,
            corePresentationModule,
            chatDataModule
        )
    }
}