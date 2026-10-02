import io.gizmolab.gizbookspace.buildlogic.libs
import io.gizmolab.gizbookspace.buildlogic.library
import io.gizmolab.gizbookspace.buildlogic.pluginId
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

/**
 * A feature module: a Compose library with type-safe navigation routes, Koin ViewModels and
 * the core modules every screen needs. Features never depend on one another; :app wires
 * navigation between them.
 */
class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply(libs.pluginId("gizbook-android-library"))
            pluginManager.apply(libs.pluginId("gizbook-android-compose"))
            pluginManager.apply(libs.pluginId("jetbrains-kotlin-serialization"))

            dependencies {
                add("implementation", project(":core:common"))
                add("implementation", project(":core:model"))
                add("implementation", project(":core:data"))
                add("implementation", project(":core:designsystem"))
                add("implementation", project(":core:ui"))

                add("implementation", libs.library("androidx-navigation-compose"))
                add("implementation", libs.library("androidx-lifecycle-runtime-compose"))
                add("implementation", libs.library("koin-androidx-compose"))
                add("implementation", libs.library("kotlinx-serialization"))
                add("implementation", libs.library("kotlinResult"))

                add("testImplementation", project(":core:testing"))
            }
        }
    }
}
