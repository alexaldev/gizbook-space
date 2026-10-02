package io.gizmolab.gizbookspace.feature.settings.di

import io.gizmolab.gizbookspace.feature.settings.SettingsViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val settingsModule =
    module {
        viewModelOf(::SettingsViewModel)
    }
