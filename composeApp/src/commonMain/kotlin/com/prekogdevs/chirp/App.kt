package com.prekogdevs.chirp

import androidx.compose.runtime.Composable
import com.prekogdevs.auth.presentation.register.RegisterRoot
import com.prekogdevs.core.designsystem.theme.ChirpTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    ChirpTheme {
        RegisterRoot(
            onRegisterSuccess = {}
        )
    }
}