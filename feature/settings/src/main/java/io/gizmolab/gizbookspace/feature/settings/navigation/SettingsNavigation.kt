package io.gizmolab.gizbookspace.feature.settings.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import io.gizmolab.gizbookspace.feature.settings.SettingsScreen
import kotlinx.serialization.Serializable

@Serializable
data object SettingsRoute

fun NavController.navigateToSettings() {
    navigate(SettingsRoute) { launchSingleTop = true }
}

fun NavGraphBuilder.settingsScreen(onBackClick: () -> Unit) {
    composable<SettingsRoute> { SettingsScreen(onBackClick = onBackClick) }
}
