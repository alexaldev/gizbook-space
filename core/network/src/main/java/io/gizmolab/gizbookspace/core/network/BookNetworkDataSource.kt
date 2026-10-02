package io.gizmolab.gizbookspace.core.network

import io.gizmolab.gizbookspace.core.network.model.BookCopyDto
import io.gizmolab.gizbookspace.core.network.model.BookDto
import io.gizmolab.gizbookspace.core.network.model.LibraryDto

/**
 * The GizBook REST API. Its contract is still being written, so for now only
 * [fake.FakeBookNetworkDataSource] implements this; an HTTP-backed implementation replaces it
 * in [di.networkModule] once the endpoints exist. Implementations throw on failure, and the
 * data layer turns that into a DataError.
 */
interface BookNetworkDataSource {
    suspend fun getNewlyAdded(limit: Int): List<BookDto>

    suspend fun getCatalogue(page: Int, pageSize: Int): List<BookDto>

    suspend fun search(query: String): List<BookDto>

    /** Returns null when no book has [id]. */
    suspend fun getBook(id: String): BookDto?

    suspend fun getBookCopies(bookId: String): List<BookCopyDto>

    suspend fun getLibraries(): List<LibraryDto>

    suspend fun getLibraryBooks(libraryId: String): List<BookDto>
}
