package io.gizmolab.gizbookspace.core.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import io.gizmolab.gizbookspace.core.model.ThemeMode
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserPreferencesDataSource(
    private val dataStore: DataStore<Preferences>,
) {
    val themeMode: Flow<ThemeMode> =
        dataStore.data.map { preferences ->
            preferences[THEME_MODE]
                ?.let { stored -> ThemeMode.entries.find { it.name == stored } }
                ?: ThemeMode.SYSTEM
        }

    suspend fun setThemeMode(themeMode: ThemeMode) {
        dataStore.edit { it[THEME_MODE] = themeMode.name }
    }

    private companion object {
        val THEME_MODE = stringPreferencesKey("theme_mode")
    }
}
