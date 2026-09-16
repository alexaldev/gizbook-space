package io.gizmolab.gizbookspace.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import io.gizmolab.gizbookspace.presentation.screens.CatalogueScreen
import io.gizmolab.gizbookspace.presentation.screens.HomeScreen
import io.gizmolab.gizbookspace.presentation.screens.LibrariesScreen
import io.gizmolab.gizbookspace.presentation.screens.SettingsScreen

@Composable
fun GizBookNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = Home,
        modifier = modifier,
    ) {
        composable<Home> { HomeScreen() }
        composable<Catalogue> { CatalogueScreen() }
        composable<Libraries> { LibrariesScreen() }
        composable<Settings> { SettingsScreen() }
    }
}
