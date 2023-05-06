package com.selcannarin.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

class AppPref(var context:Context) {
    val Context.ds : DataStore<Preferences> by preferencesDataStore("Counter")

    companion object{
        val COUNTER_KEY = intPreferencesKey("COUNTER")
    }

    suspend fun addCounter(counter:Int){
        context.ds.edit {
            it[COUNTER_KEY] = counter
        }
    }

    suspend fun readCounter():Int{
        val read = context.ds.data.first()
        return read[COUNTER_KEY] ?: 0
    }

}