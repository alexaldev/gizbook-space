package io.gizmolab.gizbookspace.core.data.repository

import io.gizmolab.gizbookspace.core.common.DataResult
import io.gizmolab.gizbookspace.core.model.Book
import io.gizmolab.gizbookspace.core.model.BookCopy

interface BookRepository {
    suspend fun getNewlyAdded(limit: Int = DEFAULT_NEWLY_ADDED_LIMIT): DataResult<List<Book>>

    suspend fun getCatalogue(page: Int, pageSize: Int = DEFAULT_PAGE_SIZE): DataResult<List<Book>>

    suspend fun search(query: String): DataResult<List<Book>>

    suspend fun getBook(id: String): DataResult<Book>

    /** Every copy of the book, with the library that holds it. */
    suspend fun getBookCopies(bookId: String): DataResult<List<BookCopy>>

    companion object {
        const val DEFAULT_NEWLY_ADDED_LIMIT = 20
        const val DEFAULT_PAGE_SIZE = 20
    }
}
