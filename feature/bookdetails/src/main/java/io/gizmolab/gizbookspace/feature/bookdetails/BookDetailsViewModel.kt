package io.gizmolab.gizbookspace.feature.bookdetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.michaelbull.result.andThen
import com.github.michaelbull.result.fold
import com.github.michaelbull.result.map
import io.gizmolab.gizbookspace.core.common.DataError
import io.gizmolab.gizbookspace.core.data.repository.BookRepository
import io.gizmolab.gizbookspace.core.data.repository.FavoritesRepository
import io.gizmolab.gizbookspace.core.model.Book
import io.gizmolab.gizbookspace.core.model.BookCopy
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

internal class BookDetailsViewModel(
    private val bookId: String,
    private val bookRepository: BookRepository,
    private val favoritesRepository: FavoritesRepository,
) : ViewModel() {
    private val loaded = MutableStateFlow<BookDetailsUiState>(BookDetailsUiState.Loading)

    val uiState: StateFlow<BookDetailsUiState> =
        combine(loaded, favoritesRepository.observeIsFavorite(bookId)) { state, isFavorite ->
            if (state is BookDetailsUiState.Success) state.copy(isFavorite = isFavorite) else state
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(STOP_TIMEOUT_MILLIS),
            initialValue = BookDetailsUiState.Loading,
        )

    init {
        load()
    }

    fun retry() = load()

    fun toggleFavorite() {
        val state = uiState.value as? BookDetailsUiState.Success ?: return
        viewModelScope.launch {
            if (state.isFavorite) {
                favoritesRepository.removeFavorite(state.book.id)
            } else {
                favoritesRepository.addFavorite(state.book)
            }
        }
    }

    private fun load() {
        loaded.value = BookDetailsUiState.Loading
        viewModelScope.launch {
            loaded.value =
                bookRepository
                    .getBook(bookId)
                    .andThen { book ->
                        bookRepository.getBookCopies(bookId).map { copies ->
                            BookDetailsUiState.Success(book = book, copies = copies, isFavorite = false)
                        }
                    }.fold(
                        success = { it },
                        failure = { BookDetailsUiState.Error(it) },
                    )
        }
    }

    private companion object {
        const val STOP_TIMEOUT_MILLIS = 5_000L
    }
}

internal sealed interface BookDetailsUiState {
    data object Loading : BookDetailsUiState

    data class Success(
        val book: Book,
        val copies: List<BookCopy>,
        val isFavorite: Boolean,
    ) : BookDetailsUiState

    data class Error(val error: DataError) : BookDetailsUiState
}
