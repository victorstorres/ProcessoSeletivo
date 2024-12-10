package com.example.processo_seletivo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.processo_seletivo.navigation.navigations.HomeNavigation
import com.example.processo_seletivo.navigation.navigations.SplashScreenNavigation
import com.example.processo_seletivo.navigation.navigations.Splash_SCREEN_ROUTE


@Composable
fun ShopperNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Splash_SCREEN_ROUTE) {
        SplashScreenNavigation(navController)
        HomeNavigation(navController)
    }
}





