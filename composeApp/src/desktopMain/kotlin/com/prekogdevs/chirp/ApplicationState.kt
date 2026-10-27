package com.prekogdevs.chirp

import androidx.compose.ui.window.TrayState
import com.prekogdevs.chirp.windows.WindowState
import com.prekogdevs.core.domain.preferences.ThemePreference

data class ApplicationState(
    val windows: List<WindowState> = listOf(WindowState()),
    val themePreference: ThemePreference = ThemePreference.SYSTEM,
    val trayState: TrayState = TrayState()
)
