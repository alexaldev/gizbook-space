package io.gizmolab.gizbookspace.feature.catalogue

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import io.gizmolab.gizbookspace.core.ui.PlaceholderScreen

@Composable
internal fun CatalogueScreen(modifier: Modifier = Modifier) {
    PlaceholderScreen(
        label = stringResource(R.string.catalogue_title),
        modifier = modifier,
    )
}
