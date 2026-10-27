package com.prekogdevs.core.data.di

import com.prekogdevs.core.data.auth.DataStoreSessionStorage
import com.prekogdevs.core.data.auth.KtorAuthService
import com.prekogdevs.core.data.logging.KermitLogger
import com.prekogdevs.core.data.networking.HttpClientFactory
import com.prekogdevs.core.domain.auth.AuthService
import com.prekogdevs.core.domain.auth.SessionStorage
import com.prekogdevs.core.domain.logging.ChirpLogger
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformCoreDataModule: Module

val coreDataModule = module {
    includes(platformCoreDataModule)
    single<ChirpLogger> { KermitLogger }
    single {
        HttpClientFactory(get(), get()).create(get())
    }
    singleOf(::KtorAuthService) bind AuthService::class
    singleOf(::DataStoreSessionStorage) bind SessionStorage::class
}