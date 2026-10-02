package io.gizmolab.gizbookspace.core.data.repository

import io.gizmolab.gizbookspace.core.model.Book
import kotlinx.coroutines.flow.Flow

/** Favourites are kept on the device only; there is no account to sync them to. */
interface FavoritesRepository {
    /** Most recently favourited first. */
    fun observeFavorites(): Flow<List<Book>>

    fun observeIsFavorite(bookId: String): Flow<Boolean>

    suspend fun addFavorite(book: Book)

    suspend fun removeFavorite(bookId: String)
}
