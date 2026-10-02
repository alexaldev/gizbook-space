package io.gizmolab.gizbookspace.core.database.di

import androidx.room.Room
import io.gizmolab.gizbookspace.core.database.GizBookDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule =
    module {
        single {
            Room.databaseBuilder(androidContext(), GizBookDatabase::class.java, "gizbook.db").build()
        }
        single { get<GizBookDatabase>().favoritesDao() }
    }
