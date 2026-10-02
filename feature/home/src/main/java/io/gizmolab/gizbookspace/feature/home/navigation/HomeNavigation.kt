package io.gizmolab.gizbookspace.feature.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import io.gizmolab.gizbookspace.feature.home.HomeScreen
import kotlinx.serialization.Serializable

@Serializable
data object HomeRoute

fun NavGraphBuilder.homeScreen(
    onBookClick: (bookId: String) -> Unit,
    onSettingsClick: () -> Unit,
) {
    composable<HomeRoute> {
        HomeScreen(onBookClick = onBookClick, onSettingsClick = onSettingsClick)
    }
}
