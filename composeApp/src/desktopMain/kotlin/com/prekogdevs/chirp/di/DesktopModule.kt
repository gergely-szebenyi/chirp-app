package com.prekogdevs.chirp.di

import com.prekogdevs.chirp.ApplicationStateHolder
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val desktopModule = module {
    singleOf(::ApplicationStateHolder)
}