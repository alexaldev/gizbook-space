package io.gizmolab.gizbookspace.core.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// Field names are a best guess until the API contract is settled.

@Serializable
data class BookDto(
    val id: String,
    val title: String,
    val authors: List<AuthorDto>,
    val isbn: String? = null,
    @SerialName("cover_url") val coverUrl: String? = null,
    val description: String? = null,
    val genres: List<GenreDto> = emptyList(),
    @SerialName("added_at") val addedAtEpochMillis: Long,
)

@Serializable
data class AuthorDto(
    val id: String,
    val name: String,
)

@Serializable
data class GenreDto(
    val id: String,
    val name: String,
)

@Serializable
data class LibraryDto(
    val id: String,
    val name: String,
    val address: String,
)

@Serializable
data class BookCopyDto(
    @SerialName("book_id") val bookId: String,
    @SerialName("library_id") val libraryId: String,
    val shelf: String,
    val available: Boolean,
)
