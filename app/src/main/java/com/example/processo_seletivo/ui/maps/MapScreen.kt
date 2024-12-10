package com.example.processo_seletivo.ui.maps

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.rememberCameraPositionState

@SuppressLint("UnrememberedMutableState")
@Composable
fun MapScreen(
    modifier: Modifier = Modifier,
    state: MapState = MapState()) {


    val cameraPositionState = rememberCameraPositionState()
    state.lastKnownLocation?.let {
        LaunchedEffect(Unit) {
            val latLng = LatLng(it.latitude, it.longitude)
            cameraPositionState.move(CameraUpdateFactory.newLatLngZoom(latLng, 15f))
        }
    }

    Box(modifier) {
        GoogleMap(
            modifier = Modifier
                .fillMaxSize()
                .testTag("Map")
                .padding(),
            properties = state.mapProperties,
            cameraPositionState = cameraPositionState,
        )
    }
}