package io.gizmolab.gizbookspace.buildlogic

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

/** JUnit 5 plus the assertion and coroutine helpers every module tests with. */
internal fun Project.configureUnitTests() {
    dependencies {
        add("testImplementation", libs.library("junit5-api"))
        add("testImplementation", libs.library("junit5-params"))
        add("testImplementation", libs.library("assertk"))
        add("testImplementation", libs.library("mockk"))
        add("testImplementation", libs.library("turbine"))
        add("testImplementation", libs.library("coroutines-test"))
        add("testRuntimeOnly", libs.library("junit5-engine"))
        add("testRuntimeOnly", libs.library("junit5-launcher"))
    }
}
