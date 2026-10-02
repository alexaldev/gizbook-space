package io.gizmolab.gizbookspace.core.network.di

import io.gizmolab.gizbookspace.core.network.BookNetworkDataSource
import io.gizmolab.gizbookspace.core.network.fake.FakeBookNetworkDataSource
import org.koin.dsl.module

val networkModule =
    module {
        // Swap for the HTTP implementation once the API contract exists.
        single<BookNetworkDataSource> { FakeBookNetworkDataSource() }
    }
