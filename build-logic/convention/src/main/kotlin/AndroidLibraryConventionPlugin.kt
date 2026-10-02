import com.android.build.api.dsl.LibraryExtension
import io.gizmolab.gizbookspace.buildlogic.configureAndroid
import io.gizmolab.gizbookspace.buildlogic.libs
import io.gizmolab.gizbookspace.buildlogic.pluginId
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply(libs.pluginId("android-library"))
            pluginManager.apply(libs.pluginId("gizbook-detekt"))

            extensions.configure<LibraryExtension> {
                configureAndroid(this)
                // :core:designsystem -> io.gizmolab.gizbookspace.core.designsystem
                namespace = "io.gizmolab.gizbookspace" + path.replace(':', '.')
            }
        }
    }
}
