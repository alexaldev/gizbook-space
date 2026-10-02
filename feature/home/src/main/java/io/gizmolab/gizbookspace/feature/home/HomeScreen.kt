package io.gizmolab.gizbookspace.feature.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import io.gizmolab.gizbookspace.core.designsystem.AppTheme
import io.gizmolab.gizbookspace.core.ui.BookCard
import io.gizmolab.gizbookspace.core.ui.ErrorState
import io.gizmolab.gizbookspace.core.ui.LoadingState
import org.koin.compose.viewmodel.koinViewModel

@Composable
internal fun HomeScreen(
    onBookClick: (bookId: String) -> Unit,
    onSettingsClick: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = koinViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    HomeScreen(
        uiState = uiState,
        onBookClick = onBookClick,
        onSettingsClick = onSettingsClick,
        onRetry = viewModel::retry,
        modifier = modifier,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun HomeScreen(
    uiState: HomeUiState,
    onBookClick: (bookId: String) -> Unit,
    onSettingsClick: () -> Unit,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(R.string.home_title)) },
                actions = {
                    IconButton(onClick = onSettingsClick) {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = stringResource(R.string.home_open_settings),
                        )
                    }
                },
            )
        },
    ) { innerPadding ->
        val contentModifier = Modifier.padding(innerPadding)
        when (uiState) {
            HomeUiState.Loading -> LoadingState(modifier = contentModifier)
            is HomeUiState.Error -> ErrorState(error = uiState.error, onRetry = onRetry, modifier = contentModifier)
            is HomeUiState.Success ->
                LazyColumn(
                    modifier = contentModifier,
                    contentPadding = PaddingValues(AppTheme.spacing.medium),
                    verticalArrangement = Arrangement.spacedBy(AppTheme.spacing.small),
                ) {
                    item {
                        Text(
                            text = stringResource(R.string.home_newly_added),
                            style = MaterialTheme.typography.titleLarge,
                        )
                    }
                    items(uiState.newlyAdded, key = { it.id }) { book ->
                        BookCard(book = book, onClick = { onBookClick(book.id) })
                    }
                }
        }
    }
}
