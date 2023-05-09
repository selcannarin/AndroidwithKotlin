package com.selcannarin.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first


private val Context.dataStore by preferencesDataStore(name = "my_prefs")

class AppPreferences(context: Context) {
    private val dataStore = context.dataStore

    companion object {
        val LOGIN_COUNT_KEY = intPreferencesKey("login_count")
    }

    suspend fun incrementLoginCount() {
        dataStore.edit { preferences ->
            val currentCount = preferences[LOGIN_COUNT_KEY] ?: 0
            preferences[LOGIN_COUNT_KEY] = currentCount + 1
        }
    }

    suspend fun getLoginCount(): Int {
        val preferences = dataStore.data.first()
        return preferences[LOGIN_COUNT_KEY] ?: 0
    }
}