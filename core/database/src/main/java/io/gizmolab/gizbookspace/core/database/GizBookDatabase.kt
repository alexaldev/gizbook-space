package io.gizmolab.gizbookspace.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import io.gizmolab.gizbookspace.core.database.dao.FavoritesDao
import io.gizmolab.gizbookspace.core.database.model.FavoriteBookEntity

@Database(
    entities = [FavoriteBookEntity::class],
    version = 1,
    exportSchema = true,
)
abstract class GizBookDatabase : RoomDatabase() {
    abstract fun favoritesDao(): FavoritesDao
}
