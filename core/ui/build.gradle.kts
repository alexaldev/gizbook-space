plugins {
    alias(libs.plugins.gizbook.android.library)
    alias(libs.plugins.gizbook.android.compose)
}

dependencies {
    api(projects.core.designsystem)
    implementation(projects.core.common)
    implementation(projects.core.model)
}
