package io.gizmolab.gizbookspace.feature.favorites

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
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
import io.gizmolab.gizbookspace.core.ui.LoadingState
import io.gizmolab.gizbookspace.core.ui.PlaceholderScreen
import org.koin.compose.viewmodel.koinViewModel

@Composable
internal fun FavoritesScreen(
    onBookClick: (bookId: String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: FavoritesViewModel = koinViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    FavoritesScreen(uiState = uiState, onBookClick = onBookClick, modifier = modifier)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun FavoritesScreen(
    uiState: FavoritesUiState,
    onBookClick: (bookId: String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = { TopAppBar(title = { Text(text = stringResource(R.string.favorites_title)) }) },
    ) { innerPadding ->
        val contentModifier = Modifier.padding(innerPadding)
        when {
            uiState is FavoritesUiState.Loading -> LoadingState(modifier = contentModifier)
            uiState is FavoritesUiState.Loaded && uiState.books.isEmpty() ->
                PlaceholderScreen(label = stringResource(R.string.favorites_empty), modifier = contentModifier)
            uiState is FavoritesUiState.Loaded ->
                LazyColumn(
                    modifier = contentModifier,
                    contentPadding = PaddingValues(AppTheme.spacing.medium),
                    verticalArrangement = Arrangement.spacedBy(AppTheme.spacing.small),
                ) {
                    items(uiState.books, key = { it.id }) { book ->
                        BookCard(book = book, onClick = { onBookClick(book.id) })
                    }
                }
        }
    }
}
