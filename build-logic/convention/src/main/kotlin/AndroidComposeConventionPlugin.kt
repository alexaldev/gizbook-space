import com.android.build.api.dsl.CommonExtension
import io.gizmolab.gizbookspace.buildlogic.libs
import io.gizmolab.gizbookspace.buildlogic.library
import io.gizmolab.gizbookspace.buildlogic.pluginId
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

/** Applied on top of gizbook.android.application or gizbook.android.library. */
class AndroidComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply(libs.pluginId("compose-compiler"))

            extensions.getByType<CommonExtension>().buildFeatures.compose = true

            dependencies {
                val bom = platform(libs.library("androidx-compose-bom"))
                add("implementation", bom)
                add("implementation", libs.library("androidx-compose-ui"))
                add("implementation", libs.library("androidx-compose-ui-graphics"))
                add("implementation", libs.library("androidx-compose-ui-tooling-preview"))
                add("implementation", libs.library("androidx-compose-material3"))
                add("debugImplementation", libs.library("androidx-compose-ui-tooling"))
                add("debugImplementation", libs.library("androidx-compose-ui-test-manifest"))
                add("androidTestImplementation", bom)
                add("androidTestImplementation", libs.library("androidx-compose-ui-test-junit4"))
            }
        }
    }
}
