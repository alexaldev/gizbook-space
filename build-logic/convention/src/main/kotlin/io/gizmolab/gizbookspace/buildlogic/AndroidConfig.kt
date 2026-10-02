package io.gizmolab.gizbookspace.buildlogic

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project

internal const val COMPILE_SDK = 37
internal const val TARGET_SDK = 37
internal const val MIN_SDK = 24

/** Common to the application and every Android library. */
internal fun Project.configureAndroid(extension: CommonExtension) {
    extension.compileSdk = COMPILE_SDK
    extension.defaultConfig.minSdk = MIN_SDK
    // AGP 9's built-in Kotlin takes its JVM target from these, so there is no kotlinOptions block.
    extension.compileOptions.sourceCompatibility = JavaVersion.VERSION_17
    extension.compileOptions.targetCompatibility = JavaVersion.VERSION_17
    extension.testOptions.unitTests.all { it.useJUnitPlatform() }

    configureUnitTests()
}
