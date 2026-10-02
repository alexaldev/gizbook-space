package io.gizmolab.gizbookspace.core.testing.repository

import io.gizmolab.gizbookspace.core.data.repository.FavoritesRepository
import io.gizmolab.gizbookspace.core.model.Book
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update

class FakeFavoritesRepository(
    initial: List<Book> = emptyList(),
) : FavoritesRepository {
    private val favorites = MutableStateFlow(initial)

    override fun observeFavorites(): Flow<List<Book>> = favorites

    override fun observeIsFavorite(bookId: String): Flow<Boolean> =
        favorites.map { books -> books.any { it.id == bookId } }

    override suspend fun addFavorite(book: Book) {
        favorites.update { books -> listOf(book) + books.filterNot { it.id == book.id } }
    }

    override suspend fun removeFavorite(bookId: String) {
        favorites.update { books -> books.filterNot { it.id == bookId } }
    }
}
