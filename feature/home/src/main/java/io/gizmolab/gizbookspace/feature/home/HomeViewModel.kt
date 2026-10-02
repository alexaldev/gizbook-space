package io.gizmolab.gizbookspace.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.michaelbull.result.fold
import io.gizmolab.gizbookspace.core.common.DataError
import io.gizmolab.gizbookspace.core.data.repository.BookRepository
import io.gizmolab.gizbookspace.core.model.Book
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

internal class HomeViewModel(
    private val bookRepository: BookRepository,
) : ViewModel() {
    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        load()
    }

    fun retry() = load()

    private fun load() {
        _uiState.value = HomeUiState.Loading
        viewModelScope.launch {
            _uiState.value =
                bookRepository.getNewlyAdded().fold(
                    success = { HomeUiState.Success(newlyAdded = it) },
                    failure = { HomeUiState.Error(it) },
                )
        }
    }
}

internal sealed interface HomeUiState {
    data object Loading : HomeUiState

    data class Success(val newlyAdded: List<Book>) : HomeUiState

    data class Error(val error: DataError) : HomeUiState
}
