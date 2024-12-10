package com.example.processo_seletivo.ui.maps

import android.content.Context
import android.location.Geocoder
import android.location.Location
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.processo_seletivo.preferences.PreferencesKey
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.util.Locale
import javax.inject.Inject


@HiltViewModel
class MapViewModel @Inject constructor(
    private val dataStore: DataStore<Preferences>,
) : ViewModel() {

    private val _uiState = MutableStateFlow(MapState())
    val uiState: MutableStateFlow<MapState>
        get() = _uiState


    fun verifyAddressUser(context: Context) {
        uiState.value.lastKnownLocation?.let { location: Location? ->
            location?.let {
                val geocoder = Geocoder(context, Locale.getDefault())
                val addressList = geocoder.getFromLocation(it.latitude, it.longitude, 1)
                val address = addressList?.get(0)?.getAddressLine(0)
                _uiState.value = _uiState.value.copy(
                    userAddress = address.toString()
                )
                viewModelScope.launch {
                    dataStore.edit { preferences ->
                        preferences[PreferencesKey.userLocation] = address.toString()
                    }
                }
            }
        }
    }

    fun getDeviceLocation(
        fusedLocationProviderClient: FusedLocationProviderClient
    ) {
        try {
            val locationResult = fusedLocationProviderClient.lastLocation
            locationResult.addOnCompleteListener { task ->
                if (task.isSuccessful && task.result != null) {
                    val location = task.result
                    location?.let {
                        _uiState.value = _uiState.value.copy(
                            lastKnownLocation = it,
                            mapProperties = MapProperties(
                                isMyLocationEnabled = true,
                                mapType = MapType.TERRAIN
                            )
                        )
                    }
                } else {
                    _uiState.value = _uiState.value.copy(
                        lastKnownLocation = null,
                    )
                }
            }
        } catch (e: SecurityException) {
            _uiState.value = _uiState.value.copy(
                lastKnownLocation = null,
            )
        }
    }
}