package com.prekogdevs.chirp

sealed interface MainEvent {
    data object OnSessionExpired: MainEvent
}