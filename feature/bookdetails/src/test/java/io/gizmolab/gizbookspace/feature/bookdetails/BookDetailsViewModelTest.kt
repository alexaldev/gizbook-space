package io.gizmolab.gizbookspace.feature.bookdetails

import app.cash.turbine.test
import assertk.assertThat
import assertk.assertions.isEqualTo
import io.gizmolab.gizbookspace.core.common.DataError
import io.gizmolab.gizbookspace.core.testing.MainDispatcherExtension
import io.gizmolab.gizbookspace.core.testing.TestData
import io.gizmolab.gizbookspace.core.testing.repository.FakeBookRepository
import io.gizmolab.gizbookspace.core.testing.repository.FakeFavoritesRepository
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension

class BookDetailsViewModelTest {
    @JvmField
    @RegisterExtension
    val mainDispatcher = MainDispatcherExtension()

    private val bookRepository =
        FakeBookRepository(
            books = listOf(TestData.dune),
            copies = mapOf(TestData.dune.id to listOf(TestData.duneCopy)),
        )
    private val favoritesRepository = FakeFavoritesRepository()

    private fun viewModel(bookId: String = TestData.dune.id) =
        BookDetailsViewModel(
            bookId = bookId,
            bookRepository = bookRepository,
            favoritesRepository = favoritesRepository,
        )

    @Test
    fun `shows the book with the copies libraries hold`() =
        runTest {
            viewModel().uiState.test {
                assertThat(awaitItem()).isEqualTo(
                    BookDetailsUiState.Success(
                        book = TestData.dune,
                        copies = listOf(TestData.duneCopy),
                        isFavorite = false,
                    ),
                )
            }
        }

    @Test
    fun `an unknown book shows not found`() =
        runTest {
            viewModel(bookId = "missing").uiState.test {
                assertThat(awaitItem()).isEqualTo(BookDetailsUiState.Error(DataError.Network.NOT_FOUND))
            }
        }

    @Test
    fun `toggling favourite adds the book, and toggling again removes it`() =
        runTest {
            val viewModel = viewModel()

            viewModel.uiState.test {
                assertThat((awaitItem() as BookDetailsUiState.Success).isFavorite).isEqualTo(false)

                viewModel.toggleFavorite()
                assertThat((awaitItem() as BookDetailsUiState.Success).isFavorite).isEqualTo(true)

                viewModel.toggleFavorite()
                assertThat((awaitItem() as BookDetailsUiState.Success).isFavorite).isEqualTo(false)
            }
        }
}
