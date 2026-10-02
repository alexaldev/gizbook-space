package io.gizmolab.gizbookspace.feature.home

import app.cash.turbine.test
import assertk.assertThat
import assertk.assertions.isEqualTo
import io.gizmolab.gizbookspace.core.common.DataError
import io.gizmolab.gizbookspace.core.testing.MainDispatcherExtension
import io.gizmolab.gizbookspace.core.testing.TestData
import io.gizmolab.gizbookspace.core.testing.repository.FakeBookRepository
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension

class HomeViewModelTest {
    @JvmField
    @RegisterExtension
    val mainDispatcher = MainDispatcherExtension()

    private val bookRepository = FakeBookRepository(books = listOf(TestData.odyssey, TestData.dune))

    @Test
    fun `newly added books are shown newest first`() =
        runTest {
            val viewModel = HomeViewModel(bookRepository)

            viewModel.uiState.test {
                assertThat(awaitItem()).isEqualTo(HomeUiState.Success(listOf(TestData.dune, TestData.odyssey)))
            }
        }

    @Test
    fun `a failed load shows the error, and retrying recovers`() =
        runTest {
            bookRepository.error = DataError.Network.NO_CONNECTION
            val viewModel = HomeViewModel(bookRepository)

            viewModel.uiState.test {
                assertThat(awaitItem()).isEqualTo(HomeUiState.Error(DataError.Network.NO_CONNECTION))

                bookRepository.error = null
                viewModel.retry()

                assertThat(awaitItem()).isEqualTo(HomeUiState.Loading)
                assertThat(awaitItem()).isEqualTo(HomeUiState.Success(listOf(TestData.dune, TestData.odyssey)))
            }
        }
}
