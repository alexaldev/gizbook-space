plugins {
    alias(libs.plugins.gizbook.jvm.library)
    alias(libs.plugins.jetbrains.kotlin.serialization)
}

dependencies {
    implementation(projects.core.common)
    implementation(libs.kotlinx.serialization)
    implementation(libs.koin.core)
}
