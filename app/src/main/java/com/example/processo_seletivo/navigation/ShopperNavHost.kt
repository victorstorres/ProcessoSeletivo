package com.example.processo_seletivo.navigation


import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.processo_seletivo.ui.splashScreen.SplashScreen

private const val Splash_SCREEN_ROUTE = "SplashScreenRoute"
private const val HOME_SCREEN_ROUTE = "HomeScreenRoute"

@Composable
fun ShopperNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Splash_SCREEN_ROUTE ){
        composable(route = Splash_SCREEN_ROUTE){
            SplashScreen()
            LaunchedEffect(true) {
                kotlinx.coroutines.delay(2000)
                navController.navigateToHome()
            }
        }
        composable(route = HOME_SCREEN_ROUTE){

        }
    }

}

fun NavHostController.navigateToHome(){
    navigate(HOME_SCREEN_ROUTE)
}

