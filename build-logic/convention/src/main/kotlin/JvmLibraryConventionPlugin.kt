import io.gizmolab.gizbookspace.buildlogic.configureUnitTests
import io.gizmolab.gizbookspace.buildlogic.libs
import io.gizmolab.gizbookspace.buildlogic.pluginId
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension

/** Plain Kotlin, no Android: for modules such as :core:model that must stay platform-free. */
class JvmLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply(libs.pluginId("jetbrains-kotlin-jvm"))
            pluginManager.apply(libs.pluginId("gizbook-detekt"))

            extensions.configure<JavaPluginExtension> {
                sourceCompatibility = JavaVersion.VERSION_17
                targetCompatibility = JavaVersion.VERSION_17
            }
            extensions.configure<KotlinJvmProjectExtension> {
                compilerOptions.jvmTarget.set(JvmTarget.JVM_17)
            }
            tasks.withType<Test>().configureEach { useJUnitPlatform() }

            configureUnitTests()
        }
    }
}
