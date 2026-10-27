package com.prekogdevs.chirp

import com.prekogdevs.chirp.windows.WindowState

data class ApplicationState(
    val windows: List<WindowState> = listOf(WindowState())
)
