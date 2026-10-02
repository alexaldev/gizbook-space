package io.gizmolab.gizbookspace.core.data.mapper

import io.gizmolab.gizbookspace.core.database.model.FavoriteBookEntity
import io.gizmolab.gizbookspace.core.model.Author
import io.gizmolab.gizbookspace.core.model.Book
import io.gizmolab.gizbookspace.core.model.BookCopy
import io.gizmolab.gizbookspace.core.model.Genre
import io.gizmolab.gizbookspace.core.model.Library
import io.gizmolab.gizbookspace.core.network.model.AuthorDto
import io.gizmolab.gizbookspace.core.network.model.BookCopyDto
import io.gizmolab.gizbookspace.core.network.model.BookDto
import io.gizmolab.gizbookspace.core.network.model.GenreDto
import io.gizmolab.gizbookspace.core.network.model.LibraryDto

internal fun BookDto.asModel() =
    Book(
        id = id,
        title = title,
        authors = authors.map { it.asModel() },
        isbn = isbn,
        coverUrl = coverUrl,
        description = description,
        genres = genres.map { it.asModel() },
        addedAtEpochMillis = addedAtEpochMillis,
    )

internal fun AuthorDto.asModel() = Author(id = id, name = name)

internal fun GenreDto.asModel() = Genre(id = id, name = name)

internal fun LibraryDto.asModel() = Library(id = id, name = name, address = address)

internal fun BookCopyDto.asModel(library: LibraryDto) =
    BookCopy(library = library.asModel(), shelf = shelf, isAvailable = available)

/** The snapshot keeps author names only, so authors read back from it have no ids. */
internal fun FavoriteBookEntity.asModel() =
    Book(
        id = bookId,
        title = title,
        authors =
            authors
                .split(FavoriteBookEntity.AUTHOR_SEPARATOR)
                .filter { it.isNotEmpty() }
                .map { Author(id = "", name = it) },
        coverUrl = coverUrl,
        addedAtEpochMillis = addedAtEpochMillis,
    )

internal fun Book.asFavoriteEntity(favoritedAtEpochMillis: Long) =
    FavoriteBookEntity(
        bookId = id,
        title = title,
        authors = authors.joinToString(FavoriteBookEntity.AUTHOR_SEPARATOR) { it.name },
        coverUrl = coverUrl,
        addedAtEpochMillis = addedAtEpochMillis,
        favoritedAtEpochMillis = favoritedAtEpochMillis,
    )
