package io.gizmolab.gizbookspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import io.gizmolab.gizbookspace.core.data.repository.UserPreferencesRepository
import io.gizmolab.gizbookspace.core.designsystem.AppTheme
import io.gizmolab.gizbookspace.core.model.ThemeMode
import io.gizmolab.gizbookspace.presentation.GizBookApp
import org.koin.android.ext.android.inject

class HomeActivity : ComponentActivity() {
    private val userPreferencesRepository: UserPreferencesRepository by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val themeMode by userPreferencesRepository.themeMode.collectAsStateWithLifecycle(ThemeMode.SYSTEM)
            val darkTheme =
                when (themeMode) {
                    ThemeMode.SYSTEM -> isSystemInDarkTheme()
                    ThemeMode.LIGHT -> false
                    ThemeMode.DARK -> true
                }
            AppTheme(darkTheme = darkTheme) {
                GizBookApp()
            }
        }
    }
}
