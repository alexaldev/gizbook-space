package io.gizmolab.gizbookspace.core.model

data class Book(
    val id: String,
    val title: String,
    val authors: List<Author>,
    val isbn: String? = null,
    val coverUrl: String? = null,
    val description: String? = null,
    val genres: List<Genre> = emptyList(),
    val addedAtEpochMillis: Long,
)

data class Author(
    val id: String,
    val name: String,
)

data class Genre(
    val id: String,
    val name: String,
)
