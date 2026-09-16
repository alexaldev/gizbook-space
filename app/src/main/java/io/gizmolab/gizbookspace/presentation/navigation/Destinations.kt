package io.gizmolab.gizbookspace.presentation.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import io.gizmolab.gizbookspace.R
import kotlinx.serialization.Serializable

/**
 * A destination reachable from the bottom bar. Nested destinations added later (a book
 * detail, a library's page) do not implement this — they are pushed onto a tab's own stack.
 */
sealed interface TopLevelRoute

@Serializable
data object Home : TopLevelRoute

@Serializable
data object Catalogue : TopLevelRoute

@Serializable
data object Libraries : TopLevelRoute

@Serializable
data object Settings : TopLevelRoute

/**
 * The bottom bar's contents, in display order. Declaration order here is the tab order, and
 * the first entry is the start destination.
 */
enum class TopLevelDestination(
    val route: TopLevelRoute,
    val icon: ImageVector,
    @param:StringRes val labelRes: Int,
) {
    HOME(Home, Icons.Default.Home, R.string.nav_home),
    CATALOGUE(Catalogue, Icons.AutoMirrored.Filled.List, R.string.nav_catalogue),
    LIBRARIES(Libraries, Icons.Default.Place, R.string.nav_libraries),
    SETTINGS(Settings, Icons.Default.Settings, R.string.nav_settings),
}
