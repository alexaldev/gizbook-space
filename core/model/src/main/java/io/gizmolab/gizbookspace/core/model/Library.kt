package io.gizmolab.gizbookspace.core.model

data class Library(
    val id: String,
    val name: String,
    val address: String,
)

/** One physical copy of a book: which library holds it, and where on its shelves. */
data class BookCopy(
    val library: Library,
    val shelf: String,
    val isAvailable: Boolean,
)
