package com.example.processo_seletivo.navigation.navigations

import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

val Splash_SCREEN_ROUTE = "SplashScreenRoute"


fun NavGraphBuilder.SplashScreenNavigation(navController: NavHostController) {
    composable(route = Splash_SCREEN_ROUTE) {
        com.example.processo_seletivo.ui.splashScreen.SplashScreen()
        LaunchedEffect(true) {
            kotlinx.coroutines.delay(2000)
            navController.navigateToHome()
        }
    }
}
