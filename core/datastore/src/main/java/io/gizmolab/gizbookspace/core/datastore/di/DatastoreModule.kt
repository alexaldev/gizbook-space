package io.gizmolab.gizbookspace.core.datastore.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import io.gizmolab.gizbookspace.core.datastore.UserPreferencesDataSource
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

private val Context.userPreferences: DataStore<Preferences> by preferencesDataStore(name = "user_preferences")

val datastoreModule =
    module {
        single { UserPreferencesDataSource(androidContext().userPreferences) }
    }
