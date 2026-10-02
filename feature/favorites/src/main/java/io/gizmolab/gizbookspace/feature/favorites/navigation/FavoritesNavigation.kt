package io.gizmolab.gizbookspace.feature.favorites.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import io.gizmolab.gizbookspace.feature.favorites.FavoritesScreen
import kotlinx.serialization.Serializable

@Serializable
data object FavoritesRoute

fun NavGraphBuilder.favoritesScreen(onBookClick: (bookId: String) -> Unit) {
    composable<FavoritesRoute> { FavoritesScreen(onBookClick = onBookClick) }
}
