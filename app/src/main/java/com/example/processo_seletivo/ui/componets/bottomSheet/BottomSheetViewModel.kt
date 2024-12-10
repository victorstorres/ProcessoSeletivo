package com.example.processo_seletivo.ui.componets.bottomSheet

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.processo_seletivo.preferences.PreferencesKey
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BottomSheetViewModel @Inject constructor(
    private val dataStore: DataStore<Preferences>,

    ) : ViewModel() {

    private val _uiState = MutableStateFlow(BottomSheetUiState())
    val uiState: StateFlow<BottomSheetUiState> = _uiState.asStateFlow()

    init {
        initialLocation()
        _uiState.update { state ->
            state.copy(
                onChangedInitLocation = {
                    _uiState.value = _uiState.value.copy(
                        initLocation = it
                    )
                },
                onChangedDestination = {
                    _uiState.value = _uiState.value.copy(
                        destination = it
                    )
                }
            )
        }
    }

    fun changeForDriver(){
        _uiState.value = _uiState.value.copy(
            destineOrDrive = false
        )
    }
    fun changeForDestination(){
        _uiState.value = _uiState.value.copy(
            destineOrDrive = true
        )
    }

    private fun initialLocation() {
        viewModelScope.launch {
            dataStore.data.collect { location ->
                _uiState.value = _uiState.value.copy(
                    initLocation = location[PreferencesKey.userLocation] ?: ""
                )
            }
        }
    }
}