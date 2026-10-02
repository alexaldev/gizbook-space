package io.gizmolab.gizbookspace.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import io.gizmolab.gizbookspace.core.database.model.FavoriteBookEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoritesDao {
    @Query("SELECT * FROM favorite_books ORDER BY favoritedAtEpochMillis DESC")
    fun observeAll(): Flow<List<FavoriteBookEntity>>

    @Query("SELECT EXISTS(SELECT 1 FROM favorite_books WHERE bookId = :bookId)")
    fun observeIsFavorite(bookId: String): Flow<Boolean>

    @Upsert
    suspend fun upsert(favorite: FavoriteBookEntity)

    @Query("DELETE FROM favorite_books WHERE bookId = :bookId")
    suspend fun delete(bookId: String)
}
