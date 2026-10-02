plugins {
    alias(libs.plugins.gizbook.android.library)
    alias(libs.plugins.gizbook.android.compose)
}

dependencies {
    // Part of this module's API: screens use the theme's Material components and icons directly.
    api(libs.androidx.compose.material3)
    api(libs.androidx.compose.material.icons.core)
}
