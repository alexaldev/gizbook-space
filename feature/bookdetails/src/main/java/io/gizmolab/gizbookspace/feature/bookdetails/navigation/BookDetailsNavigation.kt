package io.gizmolab.gizbookspace.feature.bookdetails.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import io.gizmolab.gizbookspace.feature.bookdetails.BookDetailsScreen
import kotlinx.serialization.Serializable

@Serializable
data class BookDetailsRoute(val bookId: String)

fun NavController.navigateToBookDetails(
    bookId: String,
    builder: NavOptionsBuilder.() -> Unit = {},
) {
    navigate(BookDetailsRoute(bookId), builder)
}

fun NavGraphBuilder.bookDetailsScreen(onBackClick: () -> Unit) {
    composable<BookDetailsRoute> { entry ->
        BookDetailsScreen(
            bookId = entry.toRoute<BookDetailsRoute>().bookId,
            onBackClick = onBackClick,
        )
    }
}
