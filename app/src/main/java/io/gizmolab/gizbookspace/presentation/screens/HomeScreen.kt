package io.gizmolab.gizbookspace.presentation.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import io.gizmolab.gizbookspace.R

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    PlaceholderScreen(
        label = stringResource(R.string.nav_home),
        modifier = modifier,
    )
}
