package io.gizmolab.gizbookspace.feature.search

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import io.gizmolab.gizbookspace.core.ui.PlaceholderScreen

@Composable
internal fun SearchScreen(modifier: Modifier = Modifier) {
    PlaceholderScreen(
        label = stringResource(R.string.search_title),
        modifier = modifier,
    )
}
