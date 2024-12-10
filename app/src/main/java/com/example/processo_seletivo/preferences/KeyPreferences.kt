package com.example.processo_seletivo.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore


val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "location")

object PreferencesKey {
    val userLocation = stringPreferencesKey("user_location")
    val userDestination = stringPreferencesKey("user_destination")
}