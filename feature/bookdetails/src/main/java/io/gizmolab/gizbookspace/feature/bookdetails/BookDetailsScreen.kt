package io.gizmolab.gizbookspace.feature.bookdetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
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
import io.gizmolab.gizbookspace.core.model.Book
import io.gizmolab.gizbookspace.core.model.BookCopy
import io.gizmolab.gizbookspace.core.ui.ErrorState
import io.gizmolab.gizbookspace.core.ui.LoadingState
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
internal fun BookDetailsScreen(
    bookId: String,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: BookDetailsViewModel = koinViewModel { parametersOf(bookId) },
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    BookDetailsScreen(
        uiState = uiState,
        onBackClick = onBackClick,
        onFavoriteClick = viewModel::toggleFavorite,
        onRetry = viewModel::retry,
        modifier = modifier,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun BookDetailsScreen(
    uiState: BookDetailsUiState,
    onBackClick: () -> Unit,
    onFavoriteClick: () -> Unit,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    if (uiState is BookDetailsUiState.Success) Text(text = uiState.book.title)
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.bookdetails_back),
                        )
                    }
                },
                actions = {
                    if (uiState is BookDetailsUiState.Success) {
                        FavoriteButton(isFavorite = uiState.isFavorite, onClick = onFavoriteClick)
                    }
                },
            )
        },
    ) { innerPadding ->
        val contentModifier = Modifier.padding(innerPadding)
        when (uiState) {
            BookDetailsUiState.Loading -> LoadingState(modifier = contentModifier)
            is BookDetailsUiState.Error ->
                ErrorState(error = uiState.error, onRetry = onRetry, modifier = contentModifier)
            is BookDetailsUiState.Success ->
                BookDetailsContent(book = uiState.book, copies = uiState.copies, modifier = contentModifier)
        }
    }
}

@Composable
private fun FavoriteButton(
    isFavorite: Boolean,
    onClick: () -> Unit,
) {
    IconButton(onClick = onClick) {
        if (isFavorite) {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = stringResource(R.string.bookdetails_remove_favorite),
            )
        } else {
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                contentDescription = stringResource(R.string.bookdetails_add_favorite),
            )
        }
    }
}

@Composable
private fun BookDetailsContent(
    book: Book,
    copies: List<BookCopy>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(vertical = AppTheme.spacing.medium),
        verticalArrangement = Arrangement.spacedBy(AppTheme.spacing.small),
    ) {
        item { BookHeader(book = book) }
        item {
            Text(
                text = stringResource(R.string.bookdetails_where_to_find),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(horizontal = AppTheme.spacing.medium),
            )
        }
        if (copies.isEmpty()) {
            item {
                Text(
                    text = stringResource(R.string.bookdetails_no_copies),
                    modifier = Modifier.padding(horizontal = AppTheme.spacing.medium),
                )
            }
        }
        items(copies, key = { it.library.id + it.shelf }) { copy -> CopyItem(copy = copy) }
    }
}

@Composable
private fun BookHeader(
    book: Book,
    modifier: Modifier = Modifier,
) {
    val spacing = AppTheme.spacing
    Column(
        modifier = modifier.padding(horizontal = spacing.medium),
        verticalArrangement = Arrangement.spacedBy(spacing.small),
    ) {
        Text(text = book.title, style = MaterialTheme.typography.headlineSmall)
        Text(
            text = book.authors.joinToString { it.name },
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
        if (book.genres.isNotEmpty()) {
            Text(text = book.genres.joinToString { it.name }, style = MaterialTheme.typography.labelLarge)
        }
        book.isbn?.let { isbn ->
            Text(text = stringResource(R.string.bookdetails_isbn, isbn), style = MaterialTheme.typography.bodySmall)
        }
        book.description?.let { description ->
            Text(text = description, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Composable
private fun CopyItem(
    copy: BookCopy,
    modifier: Modifier = Modifier,
) {
    ListItem(
        modifier = modifier,
        headlineContent = { Text(text = copy.library.name) },
        supportingContent = { Text(text = stringResource(R.string.bookdetails_shelf, copy.shelf)) },
        trailingContent = {
            Text(
                text =
                    stringResource(
                        if (copy.isAvailable) R.string.bookdetails_available else R.string.bookdetails_on_loan,
                    ),
                color =
                    if (copy.isAvailable) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        MaterialTheme.colorScheme.onSurfaceVariant
                    },
            )
        },
    )
}
