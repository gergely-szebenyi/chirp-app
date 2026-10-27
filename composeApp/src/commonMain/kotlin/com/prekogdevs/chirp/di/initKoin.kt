package com.prekogdevs.chirp.di

import com.prekogdevs.auth.presentation.di.authPresentationModule
import com.prekogdevs.core.data.di.coreDataModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(
            coreDataModule,
            authPresentationModule,
            appModule
        )
    }
}