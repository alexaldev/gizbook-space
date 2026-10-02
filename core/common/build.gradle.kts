plugins {
    alias(libs.plugins.gizbook.jvm.library)
}

dependencies {
    api(libs.kotlinx.coroutines.core)
    api(libs.kotlinResult)
}
