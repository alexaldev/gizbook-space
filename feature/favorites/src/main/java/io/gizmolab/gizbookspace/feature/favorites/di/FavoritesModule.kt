package io.gizmolab.gizbookspace.feature.favorites.di

import io.gizmolab.gizbookspace.feature.favorites.FavoritesViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val favoritesModule =
    module {
        viewModelOf(::FavoritesViewModel)
    }
