package com.example.processo_seletivo.ui.maps

import android.location.Location
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType

data class MapState(
    val lastKnownLocation: Location? = null,
    val userAddress: String = "",
    val mapProperties: MapProperties = MapProperties(isMyLocationEnabled = false, mapType = MapType.TERRAIN)
)