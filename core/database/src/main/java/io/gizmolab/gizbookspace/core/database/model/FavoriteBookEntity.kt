package io.gizmolab.gizbookspace.core.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * A snapshot of the book as it was when favourited, so the favourites list shows without a
 * network round trip.
 */
@Entity(tableName = "favorite_books")
data class FavoriteBookEntity(
    @PrimaryKey val bookId: String,
    val title: String,
    /** Author names joined with [AUTHOR_SEPARATOR]. */
    val authors: String,
    val coverUrl: String?,
    val addedAtEpochMillis: Long,
    val favoritedAtEpochMillis: Long,
) {
    companion object {
        const val AUTHOR_SEPARATOR = "\u001F"
    }
}
