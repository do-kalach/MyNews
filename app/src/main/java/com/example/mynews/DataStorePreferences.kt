package com.example.mynews

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.domain.data.Category
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataStorePreferences(private val context: Context) {
    private val Context.dataStore by preferencesDataStore(name = "example_data_store")

    companion object {
        private val CATEGORY = stringPreferencesKey("category")
    }

    suspend fun saveName(name: Category) {
        context.dataStore.edit { preferences ->
            preferences[CATEGORY] = name.getCategory()
        }
    }

    val readName: Flow<String>
        get() = context.dataStore.data.map { preferences ->
            preferences[CATEGORY].toString()
        }
}