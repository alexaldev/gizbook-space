import dev.detekt.gradle.extensions.DetektExtension
import io.gizmolab.gizbookspace.buildlogic.libs
import io.gizmolab.gizbookspace.buildlogic.library
import io.gizmolab.gizbookspace.buildlogic.pluginId
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

/** Every module is checked against the one detekt.yml at the repository root. */
class DetektConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply(libs.pluginId("detekt"))

            extensions.configure<DetektExtension> {
                config.setFrom(rootProject.file("detekt.yml"))
                buildUponDefaultConfig.set(true)
            }

            dependencies {
                add("detektPlugins", libs.library("detekt-compose-rules"))
            }
        }
    }
}
