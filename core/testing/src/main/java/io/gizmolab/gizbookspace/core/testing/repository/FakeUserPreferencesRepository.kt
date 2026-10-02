package io.gizmolab.gizbookspace.core.testing.repository

import io.gizmolab.gizbookspace.core.data.repository.UserPreferencesRepository
import io.gizmolab.gizbookspace.core.model.ThemeMode
import kotlinx.coroutines.flow.MutableStateFlow

class FakeUserPreferencesRepository(
    initial: ThemeMode = ThemeMode.SYSTEM,
) : UserPreferencesRepository {
    override val themeMode = MutableStateFlow(initial)

    override suspend fun setThemeMode(themeMode: ThemeMode) {
        this.themeMode.value = themeMode
    }
}
