package io.gizmolab.gizbookspace.core.testing

import io.gizmolab.gizbookspace.core.model.Author
import io.gizmolab.gizbookspace.core.model.Book
import io.gizmolab.gizbookspace.core.model.BookCopy
import io.gizmolab.gizbookspace.core.model.Library

@Suppress("MagicNumber")
object TestData {
    val centralLibrary = Library(id = "central", name = "Central Library", address = "1 Main Square")

    val dune =
        Book(
            id = "dune",
            title = "Dune",
            authors = listOf(Author(id = "herbert", name = "Frank Herbert")),
            addedAtEpochMillis = 2_000L,
        )

    val odyssey =
        Book(
            id = "odyssey",
            title = "The Odyssey",
            authors = listOf(Author(id = "homer", name = "Homer")),
            addedAtEpochMillis = 1_000L,
        )

    val duneCopy = BookCopy(library = centralLibrary, shelf = "SF-HER-2", isAvailable = true)
}
