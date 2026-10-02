package io.gizmolab.gizbookspace.feature.home.di

import io.gizmolab.gizbookspace.feature.home.HomeViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val homeModule =
    module {
        viewModelOf(::HomeViewModel)
    }
