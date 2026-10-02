package io.gizmolab.gizbookspace.core.testing.repository

import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import io.gizmolab.gizbookspace.core.common.DataError
import io.gizmolab.gizbookspace.core.common.DataResult
import io.gizmolab.gizbookspace.core.data.repository.BookRepository
import io.gizmolab.gizbookspace.core.model.Book
import io.gizmolab.gizbookspace.core.model.BookCopy

/** Serves [books] and [copies]; set [error] to make every call fail with it. */
class FakeBookRepository(
    var books: List<Book> = emptyList(),
    var copies: Map<String, List<BookCopy>> = emptyMap(),
    var error: DataError? = null,
) : BookRepository {
    override suspend fun getNewlyAdded(limit: Int): DataResult<List<Book>> =
        respond { books.sortedByDescending { it.addedAtEpochMillis }.take(limit) }

    override suspend fun getCatalogue(page: Int, pageSize: Int): DataResult<List<Book>> =
        respond { books.drop(page * pageSize).take(pageSize) }

    override suspend fun search(query: String): DataResult<List<Book>> =
        respond { books.filter { it.title.contains(query, ignoreCase = true) } }

    override suspend fun getBook(id: String): DataResult<Book> {
        error?.let { return Err(it) }
        return books.find { it.id == id }?.let(::Ok) ?: Err(DataError.Network.NOT_FOUND)
    }

    override suspend fun getBookCopies(bookId: String): DataResult<List<BookCopy>> =
        respond { copies[bookId].orEmpty() }

    private fun <T> respond(block: () -> T): DataResult<T> = error?.let(::Err) ?: Ok(block())
}
