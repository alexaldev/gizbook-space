package io.gizmolab.gizbookspace.core.network.fake

import io.gizmolab.gizbookspace.core.network.model.AuthorDto
import io.gizmolab.gizbookspace.core.network.model.BookCopyDto
import io.gizmolab.gizbookspace.core.network.model.BookDto
import io.gizmolab.gizbookspace.core.network.model.GenreDto
import io.gizmolab.gizbookspace.core.network.model.LibraryDto

/** Sample data standing in for the API. */
@Suppress("MagicNumber")
internal object FakeCatalogue {
    private val fiction = GenreDto(id = "fiction", name = "Fiction")
    private val sciFi = GenreDto(id = "sci-fi", name = "Science fiction")
    private val classics = GenreDto(id = "classics", name = "Classics")
    private val nonFiction = GenreDto(id = "non-fiction", name = "Non-fiction")

    val libraries =
        listOf(
            LibraryDto(id = "central", name = "Central Library", address = "1 Main Square"),
            LibraryDto(id = "riverside", name = "Riverside Branch", address = "42 River Road"),
            LibraryDto(id = "university", name = "University Library", address = "7 Campus Avenue"),
        )

    val books =
        listOf(
            BookDto(
                id = "dune",
                title = "Dune",
                authors = listOf(AuthorDto(id = "herbert", name = "Frank Herbert")),
                isbn = "9780441172719",
                description = "A desert planet, a noble family and the spice that everyone wants.",
                genres = listOf(fiction, sciFi),
                addedAtEpochMillis = 1_780_000_000_000,
            ),
            BookDto(
                id = "left-hand",
                title = "The Left Hand of Darkness",
                authors = listOf(AuthorDto(id = "le-guin", name = "Ursula K. Le Guin")),
                isbn = "9780441478125",
                description = "An envoy on a world whose people have no fixed sex.",
                genres = listOf(fiction, sciFi),
                addedAtEpochMillis = 1_785_000_000_000,
            ),
            BookDto(
                id = "middlemarch",
                title = "Middlemarch",
                authors = listOf(AuthorDto(id = "eliot", name = "George Eliot")),
                isbn = "9780141439549",
                description = "Life, marriage and ambition in a provincial English town.",
                genres = listOf(fiction, classics),
                addedAtEpochMillis = 1_770_000_000_000,
            ),
            BookDto(
                id = "odyssey",
                title = "The Odyssey",
                authors = listOf(AuthorDto(id = "homer", name = "Homer")),
                isbn = "9780140268867",
                description = "Odysseus's ten-year voyage home from Troy.",
                genres = listOf(classics),
                addedAtEpochMillis = 1_760_000_000_000,
            ),
            BookDto(
                id = "sapiens",
                title = "Sapiens",
                authors = listOf(AuthorDto(id = "harari", name = "Yuval Noah Harari")),
                isbn = "9780062316097",
                description = "A brief history of humankind.",
                genres = listOf(nonFiction),
                addedAtEpochMillis = 1_788_000_000_000,
            ),
            BookDto(
                id = "dispossessed",
                title = "The Dispossessed",
                authors = listOf(AuthorDto(id = "le-guin", name = "Ursula K. Le Guin")),
                isbn = "9780061054884",
                description = "A physicist travels between an anarchist moon and its capitalist planet.",
                genres = listOf(fiction, sciFi),
                addedAtEpochMillis = 1_789_000_000_000,
            ),
        )

    val copies =
        listOf(
            BookCopyDto(bookId = "dune", libraryId = "central", shelf = "SF-HER-2", available = true),
            BookCopyDto(bookId = "dune", libraryId = "riverside", shelf = "B3 / 14", available = false),
            BookCopyDto(bookId = "left-hand", libraryId = "central", shelf = "SF-LEG-1", available = true),
            BookCopyDto(bookId = "middlemarch", libraryId = "university", shelf = "823.8 ELI", available = true),
            BookCopyDto(bookId = "odyssey", libraryId = "central", shelf = "CL-HOM-1", available = false),
            BookCopyDto(bookId = "odyssey", libraryId = "university", shelf = "883.01 HOM", available = true),
            BookCopyDto(bookId = "sapiens", libraryId = "riverside", shelf = "A1 / 02", available = true),
            BookCopyDto(bookId = "dispossessed", libraryId = "university", shelf = "813.54 LEG", available = true),
        )
}
