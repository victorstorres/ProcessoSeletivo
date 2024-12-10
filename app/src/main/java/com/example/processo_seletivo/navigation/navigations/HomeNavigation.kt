package com.example.processo_seletivo.navigation.navigations

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.processo_seletivo.permission.LocationPermissionRequest
import com.example.processo_seletivo.ui.componets.bottomSheet.BottomSheetScreen
import com.example.processo_seletivo.ui.componets.bottomSheet.BottomSheetViewModel
import com.example.processo_seletivo.ui.home.HomeScreen
import com.example.processo_seletivo.ui.maps.MapViewModel
import com.google.android.gms.location.LocationServices

private const val HOME_SCREEN_ROUTE = "HomeScreenRoute"


fun NavGraphBuilder.HomeNavigation(
    navController: NavHostController
) {
    composable(route = HOME_SCREEN_ROUTE) {
        val mapViewModel = hiltViewModel<MapViewModel>()
        val mapState by mapViewModel.uiState.collectAsState()

        val bottomSheetViewModel = hiltViewModel<BottomSheetViewModel>()
        val bottomSheetUiState by bottomSheetViewModel.uiState.collectAsState()

        val context = LocalContext.current
        val fusedLocationProviderClient = remember {
            LocationServices.getFusedLocationProviderClient(context)
        }
        LocationPermissionRequest(
            onPermissionGranted = {
                mapViewModel.getDeviceLocation(fusedLocationProviderClient)
                mapViewModel.verifyAddressUser(context)
                HomeScreen(
                    bottomSheet = {
                        BottomSheetScreen(
                            mapState = mapState,
                            bottomSheetUiState = bottomSheetUiState,
                            onChangeToDriver = {
                                bottomSheetViewModel.changeForDriver()
                            },
                            onChangeToDestination = {
                                bottomSheetViewModel.changeForDestination()
                            })
                    }
                )
            },
            onPermissionDenied = {

            }
        )
    }
}


fun NavHostController.navigateToHome() {
    navigate(HOME_SCREEN_ROUTE)
}
