package io.gizmolab.gizbookspace.core.data.repository

import io.gizmolab.gizbookspace.core.datastore.UserPreferencesDataSource
import io.gizmolab.gizbookspace.core.model.ThemeMode
import kotlinx.coroutines.flow.Flow

interface UserPreferencesRepository {
    val themeMode: Flow<ThemeMode>

    suspend fun setThemeMode(themeMode: ThemeMode)
}

internal class DefaultUserPreferencesRepository(
    private val dataSource: UserPreferencesDataSource,
) : UserPreferencesRepository {
    override val themeMode: Flow<ThemeMode> = dataSource.themeMode

    override suspend fun setThemeMode(themeMode: ThemeMode) = dataSource.setThemeMode(themeMode)
}
