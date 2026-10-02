package io.gizmolab.gizbookspace.core.data.di

import io.gizmolab.gizbookspace.core.common.DefaultDispatcherProvider
import io.gizmolab.gizbookspace.core.common.DispatcherProvider
import io.gizmolab.gizbookspace.core.data.repository.BookRepository
import io.gizmolab.gizbookspace.core.data.repository.DefaultBookRepository
import io.gizmolab.gizbookspace.core.data.repository.DefaultFavoritesRepository
import io.gizmolab.gizbookspace.core.data.repository.DefaultLibraryRepository
import io.gizmolab.gizbookspace.core.data.repository.DefaultUserPreferencesRepository
import io.gizmolab.gizbookspace.core.data.repository.FavoritesRepository
import io.gizmolab.gizbookspace.core.data.repository.LibraryRepository
import io.gizmolab.gizbookspace.core.data.repository.UserPreferencesRepository
import io.gizmolab.gizbookspace.core.database.di.databaseModule
import io.gizmolab.gizbookspace.core.datastore.di.datastoreModule
import io.gizmolab.gizbookspace.core.network.di.networkModule
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

/**
 * Everything below the repositories. :app loads only this; the network, database and datastore
 * modules stay implementation details of :core:data.
 */
val dataModule =
    module {
        includes(networkModule, databaseModule, datastoreModule)

        single<DispatcherProvider> { DefaultDispatcherProvider() }
        singleOf(::DefaultBookRepository) { bind<BookRepository>() }
        singleOf(::DefaultLibraryRepository) { bind<LibraryRepository>() }
        single<FavoritesRepository> { DefaultFavoritesRepository(dao = get()) }
        singleOf(::DefaultUserPreferencesRepository) { bind<UserPreferencesRepository>() }
    }
