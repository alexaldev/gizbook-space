package io.gizmolab.gizbookspace.feature.libraries

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import io.gizmolab.gizbookspace.core.ui.PlaceholderScreen

@Composable
internal fun LibrariesScreen(modifier: Modifier = Modifier) {
    PlaceholderScreen(
        label = stringResource(R.string.libraries_title),
        modifier = modifier,
    )
}
