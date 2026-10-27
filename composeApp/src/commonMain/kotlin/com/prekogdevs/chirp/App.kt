package com.prekogdevs.chirp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.prekogdevs.auth.presentation.register.RegisterRoot
import com.prekogdevs.auth.presentation.register_success.RegisterSuccessRoot
import com.prekogdevs.chirp.navigation.DeepLinkListener
import com.prekogdevs.chirp.navigation.NavigationRoot
import com.prekogdevs.core.designsystem.theme.ChirpTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    val navController = rememberNavController()
    DeepLinkListener(navController)

    ChirpTheme {
        NavigationRoot(navController)
    }
}