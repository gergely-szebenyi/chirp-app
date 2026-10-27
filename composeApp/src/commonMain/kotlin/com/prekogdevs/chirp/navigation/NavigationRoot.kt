package com.prekogdevs.chirp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.prekogdevs.auth.presentation.navigation.AuthGraphRoutes
import com.prekogdevs.auth.presentation.navigation.authGraph

@Composable
fun NavigationRoot() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AuthGraphRoutes.Graph
    ) {
        authGraph(
            navController = navController,
            onLoginSuccess = {

            }
        )
    }
}