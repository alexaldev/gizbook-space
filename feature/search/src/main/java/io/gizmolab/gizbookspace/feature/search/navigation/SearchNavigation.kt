package io.gizmolab.gizbookspace.feature.search.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import io.gizmolab.gizbookspace.feature.search.SearchScreen
import kotlinx.serialization.Serializable

@Serializable
data object SearchRoute

fun NavGraphBuilder.searchScreen() {
    composable<SearchRoute> { SearchScreen() }
}
