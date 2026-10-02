package io.gizmolab.gizbookspace.core.data.repository

import io.gizmolab.gizbookspace.core.data.mapper.asFavoriteEntity
import io.gizmolab.gizbookspace.core.data.mapper.asModel
import io.gizmolab.gizbookspace.core.database.dao.FavoritesDao
import io.gizmolab.gizbookspace.core.model.Book
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class DefaultFavoritesRepository(
    private val dao: FavoritesDao,
    private val clock: () -> Long = System::currentTimeMillis,
) : FavoritesRepository {
    override fun observeFavorites(): Flow<List<Book>> =
        dao.observeAll().map { favorites -> favorites.map { it.asModel() } }

    override fun observeIsFavorite(bookId: String): Flow<Boolean> = dao.observeIsFavorite(bookId)

    override suspend fun addFavorite(book: Book) {
        dao.upsert(book.asFavoriteEntity(favoritedAtEpochMillis = clock()))
    }

    override suspend fun removeFavorite(bookId: String) {
        dao.delete(bookId)
    }
}
