package io.gizmolab.gizbookspace.core.data.repository

import io.gizmolab.gizbookspace.core.common.DataResult
import io.gizmolab.gizbookspace.core.common.DispatcherProvider
import io.gizmolab.gizbookspace.core.data.mapper.asModel
import io.gizmolab.gizbookspace.core.model.Book
import io.gizmolab.gizbookspace.core.model.Library
import io.gizmolab.gizbookspace.core.network.BookNetworkDataSource

internal class DefaultLibraryRepository(
    private val network: BookNetworkDataSource,
    private val dispatchers: DispatcherProvider,
) : LibraryRepository {
    override suspend fun getLibraries(): DataResult<List<Library>> =
        networkCall(dispatchers) { network.getLibraries().map { it.asModel() } }

    override suspend fun getLibraryBooks(libraryId: String): DataResult<List<Book>> =
        networkCall(dispatchers) { network.getLibraryBooks(libraryId).map { it.asModel() } }
}
