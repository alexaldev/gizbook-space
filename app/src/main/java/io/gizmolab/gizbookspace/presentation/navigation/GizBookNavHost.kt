package io.gizmolab.gizbookspace.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import io.gizmolab.gizbookspace.feature.bookdetails.navigation.bookDetailsScreen
import io.gizmolab.gizbookspace.feature.bookdetails.navigation.navigateToBookDetails
import io.gizmolab.gizbookspace.feature.catalogue.navigation.catalogueScreen
import io.gizmolab.gizbookspace.feature.favorites.navigation.favoritesScreen
import io.gizmolab.gizbookspace.feature.home.navigation.HomeRoute
import io.gizmolab.gizbookspace.feature.home.navigation.homeScreen
import io.gizmolab.gizbookspace.feature.libraries.navigation.librariesScreen
import io.gizmolab.gizbookspace.feature.search.navigation.searchScreen
import io.gizmolab.gizbookspace.feature.settings.navigation.navigateToSettings
import io.gizmolab.gizbookspace.feature.settings.navigation.settingsScreen

/** Features don't know about each other; navigation between them is wired here. */
@Composable
fun GizBookNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    val onBookClick: (String) -> Unit = { bookId -> navController.navigateToBookDetails(bookId) }

    NavHost(
        navController = navController,
        startDestination = HomeRoute,
        modifier = modifier,
    ) {
        homeScreen(onBookClick = onBookClick, onSettingsClick = navController::navigateToSettings)
        searchScreen()
        catalogueScreen()
        librariesScreen()
        favoritesScreen(onBookClick = onBookClick)

        bookDetailsScreen(onBackClick = navController::popBackStack)
        settingsScreen(onBackClick = navController::popBackStack)
    }
}
