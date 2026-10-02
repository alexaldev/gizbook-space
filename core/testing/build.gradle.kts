plugins {
    alias(libs.plugins.gizbook.android.library)
}

dependencies {
    api(projects.core.data)
    api(libs.coroutines.test)
    api(libs.junit5.api)
}
