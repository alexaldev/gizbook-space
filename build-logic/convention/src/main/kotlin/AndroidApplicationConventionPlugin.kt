import com.android.build.api.dsl.ApplicationExtension
import io.gizmolab.gizbookspace.buildlogic.TARGET_SDK
import io.gizmolab.gizbookspace.buildlogic.configureAndroid
import io.gizmolab.gizbookspace.buildlogic.libs
import io.gizmolab.gizbookspace.buildlogic.pluginId
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply(libs.pluginId("android-application"))
            pluginManager.apply(libs.pluginId("gizbook-detekt"))

            extensions.configure<ApplicationExtension> {
                configureAndroid(this)
                defaultConfig.targetSdk = TARGET_SDK
            }
        }
    }
}
