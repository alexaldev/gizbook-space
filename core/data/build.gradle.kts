plugins {
    alias(libs.plugins.gizbook.android.library)
}

dependencies {
    api(projects.core.common)
    api(projects.core.model)
    implementation(projects.core.network)
    implementation(projects.core.database)
    implementation(projects.core.datastore)

    implementation(libs.koin.android)
    implementation(libs.kotlinx.serialization)
}
