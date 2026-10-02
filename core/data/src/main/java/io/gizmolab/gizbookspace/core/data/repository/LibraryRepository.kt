package io.gizmolab.gizbookspace.core.data.repository

import io.gizmolab.gizbookspace.core.common.DataResult
import io.gizmolab.gizbookspace.core.model.Book
import io.gizmolab.gizbookspace.core.model.Library

interface LibraryRepository {
    suspend fun getLibraries(): DataResult<List<Library>>

    suspend fun getLibraryBooks(libraryId: String): DataResult<List<Book>>
}
