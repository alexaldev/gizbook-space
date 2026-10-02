package io.gizmolab.gizbookspace.presentation.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import io.gizmolab.gizbookspace.R
import io.gizmolab.gizbookspace.feature.catalogue.navigation.CatalogueRoute
import io.gizmolab.gizbookspace.feature.favorites.navigation.FavoritesRoute
import io.gizmolab.gizbookspace.feature.home.navigation.HomeRoute
import io.gizmolab.gizbookspace.feature.libraries.navigation.LibrariesRoute
import io.gizmolab.gizbookspace.feature.search.navigation.SearchRoute
import kotlin.reflect.KClass

/**
 * The bottom bar's contents, in display order. Declaration order here is the tab order, and
 * the first entry is the start destination. Each route belongs to its feature module; nested
 * destinations (book details, settings) are pushed onto the current tab's own stack.
 */
enum class TopLevelDestination(
    val route: Any,
    val icon: ImageVector,
    @param:StringRes val labelRes: Int,
) {
    HOME(HomeRoute, Icons.Default.Home, R.string.nav_home),
    SEARCH(SearchRoute, Icons.Default.Search, R.string.nav_search),
    CATALOGUE(CatalogueRoute, Icons.AutoMirrored.Filled.List, R.string.nav_catalogue),
    LIBRARIES(LibrariesRoute, Icons.Default.Place, R.string.nav_libraries),
    FAVORITES(FavoritesRoute, Icons.Default.Favorite, R.string.nav_favorites),
    ;

    val routeClass: KClass<*> get() = route::class
}
