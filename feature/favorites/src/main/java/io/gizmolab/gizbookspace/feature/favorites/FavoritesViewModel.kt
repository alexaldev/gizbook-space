package io.gizmolab.gizbookspace.feature.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.gizmolab.gizbookspace.core.data.repository.FavoritesRepository
import io.gizmolab.gizbookspace.core.model.Book
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

internal class FavoritesViewModel(
    favoritesRepository: FavoritesRepository,
) : ViewModel() {
    val uiState: StateFlow<FavoritesUiState> =
        favoritesRepository
            .observeFavorites()
            .map<List<Book>, FavoritesUiState> { FavoritesUiState.Loaded(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(STOP_TIMEOUT_MILLIS),
                initialValue = FavoritesUiState.Loading,
            )

    private companion object {
        const val STOP_TIMEOUT_MILLIS = 5_000L
    }
}

internal sealed interface FavoritesUiState {
    data object Loading : FavoritesUiState

    data class Loaded(val books: List<Book>) : FavoritesUiState
}
