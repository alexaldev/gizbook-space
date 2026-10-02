package io.gizmolab.gizbookspace.feature.libraries.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import io.gizmolab.gizbookspace.feature.libraries.LibrariesScreen
import kotlinx.serialization.Serializable

@Serializable
data object LibrariesRoute

fun NavGraphBuilder.librariesScreen() {
    composable<LibrariesRoute> { LibrariesScreen() }
}
