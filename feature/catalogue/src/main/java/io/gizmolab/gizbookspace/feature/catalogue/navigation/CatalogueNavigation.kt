package io.gizmolab.gizbookspace.feature.catalogue.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import io.gizmolab.gizbookspace.feature.catalogue.CatalogueScreen
import kotlinx.serialization.Serializable

@Serializable
data object CatalogueRoute

fun NavGraphBuilder.catalogueScreen() {
    composable<CatalogueRoute> { CatalogueScreen() }
}
