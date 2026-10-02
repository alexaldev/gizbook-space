package io.gizmolab.gizbookspace.feature.bookdetails.di

import io.gizmolab.gizbookspace.feature.bookdetails.BookDetailsViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val bookDetailsModule =
    module {
        viewModel { (bookId: String) ->
            BookDetailsViewModel(bookId = bookId, bookRepository = get(), favoritesRepository = get())
        }
    }
