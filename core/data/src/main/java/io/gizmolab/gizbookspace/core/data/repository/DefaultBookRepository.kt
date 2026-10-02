package io.gizmolab.gizbookspace.core.data.repository

import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.andThen
import io.gizmolab.gizbookspace.core.common.DataError
import io.gizmolab.gizbookspace.core.common.DataResult
import io.gizmolab.gizbookspace.core.common.DispatcherProvider
import io.gizmolab.gizbookspace.core.data.mapper.asModel
import io.gizmolab.gizbookspace.core.model.Book
import io.gizmolab.gizbookspace.core.model.BookCopy
import io.gizmolab.gizbookspace.core.network.BookNetworkDataSource

internal class DefaultBookRepository(
    private val network: BookNetworkDataSource,
    private val dispatchers: DispatcherProvider,
) : BookRepository {
    override suspend fun getNewlyAdded(limit: Int): DataResult<List<Book>> =
        networkCall(dispatchers) { network.getNewlyAdded(limit).map { it.asModel() } }

    override suspend fun getCatalogue(page: Int, pageSize: Int): DataResult<List<Book>> =
        networkCall(dispatchers) { network.getCatalogue(page, pageSize).map { it.asModel() } }

    override suspend fun search(query: String): DataResult<List<Book>> =
        networkCall(dispatchers) { network.search(query).map { it.asModel() } }

    override suspend fun getBook(id: String): DataResult<Book> =
        networkCall(dispatchers) { network.getBook(id) }.andThen { dto ->
            if (dto == null) Err(DataError.Network.NOT_FOUND) else Ok(dto.asModel())
        }

    override suspend fun getBookCopies(bookId: String): DataResult<List<BookCopy>> =
        networkCall(dispatchers) {
            val librariesById = network.getLibraries().associateBy { it.id }
            network.getBookCopies(bookId).mapNotNull { copy ->
                librariesById[copy.libraryId]?.let { library -> copy.asModel(library) }
            }
        }
}
