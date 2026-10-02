plugins {
    alias(libs.plugins.gizbook.android.library)
}

dependencies {
    implementation(projects.core.model)
    implementation(libs.androidx.datastore.preferences)
    implementation(libs.koin.android)
}
