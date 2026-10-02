package io.gizmolab.gizbookspace

import android.app.Application
import io.gizmolab.gizbookspace.core.data.di.dataModule
import io.gizmolab.gizbookspace.feature.bookdetails.di.bookDetailsModule
import io.gizmolab.gizbookspace.feature.favorites.di.favoritesModule
import io.gizmolab.gizbookspace.feature.home.di.homeModule
import io.gizmolab.gizbookspace.feature.settings.di.settingsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class GizBookApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@GizBookApplication)
            modules(
                dataModule,
                homeModule,
                bookDetailsModule,
                favoritesModule,
                settingsModule,
            )
        }
    }
}
