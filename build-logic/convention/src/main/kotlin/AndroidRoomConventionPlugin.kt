import com.google.devtools.ksp.gradle.KspExtension
import io.gizmolab.gizbookspace.buildlogic.libs
import io.gizmolab.gizbookspace.buildlogic.library
import io.gizmolab.gizbookspace.buildlogic.pluginId
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidRoomConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply(libs.pluginId("ksp"))

            extensions.configure<KspExtension> {
                // Exported schemas are committed, so migrations can be checked against them.
                arg("room.schemaLocation", layout.projectDirectory.dir("schemas").asFile.path)
            }

            dependencies {
                add("implementation", libs.library("room-runtime"))
                add("implementation", libs.library("room-ktx"))
                add("ksp", libs.library("room-compiler"))
            }
        }
    }
}
