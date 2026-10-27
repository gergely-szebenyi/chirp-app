package com.prekogdevs.auth.presentation.login

sealed interface LoginEvent {
    data object Success: LoginEvent
}