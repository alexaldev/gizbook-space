package io.gizmolab.gizbookspace.core.network.fake

import io.gizmolab.gizbookspace.core.network.BookNetworkDataSource
import io.gizmolab.gizbookspace.core.network.model.BookCopyDto
import io.gizmolab.gizbookspace.core.network.model.BookDto
import io.gizmolab.gizbookspace.core.network.model.LibraryDto
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

/** Serves [FakeCatalogue] with a short delay, so loading states are visible. */
class FakeBookNetworkDataSource : BookNetworkDataSource {
    override suspend fun getNewlyAdded(limit: Int): List<BookDto> =
        respond { FakeCatalogue.books.sortedByDescending { it.addedAtEpochMillis }.take(limit) }

    override suspend fun getCatalogue(page: Int, pageSize: Int): List<BookDto> =
        respond { FakeCatalogue.books.sortedBy { it.title }.drop(page * pageSize).take(pageSize) }

    override suspend fun search(query: String): List<BookDto> =
        respond {
            FakeCatalogue.books.filter { book ->
                book.title.contains(query, ignoreCase = true) ||
                    book.authors.any { it.name.contains(query, ignoreCase = true) }
            }
        }

    override suspend fun getBook(id: String): BookDto? = respond { FakeCatalogue.books.find { it.id == id } }

    override suspend fun getBookCopies(bookId: String): List<BookCopyDto> =
        respond { FakeCatalogue.copies.filter { it.bookId == bookId } }

    override suspend fun getLibraries(): List<LibraryDto> = respond { FakeCatalogue.libraries }

    override suspend fun getLibraryBooks(libraryId: String): List<BookDto> =
        respond {
            val bookIds = FakeCatalogue.copies.filter { it.libraryId == libraryId }.map { it.bookId }.toSet()
            FakeCatalogue.books.filter { it.id in bookIds }
        }

    private suspend fun <T> respond(block: () -> T): T {
        delay(LATENCY)
        return block()
    }

    private companion object {
        val LATENCY = 300.milliseconds
    }
}
