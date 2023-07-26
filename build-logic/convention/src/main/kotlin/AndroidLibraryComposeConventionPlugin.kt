import com.android.build.gradle.LibraryExtension
import com.android_project_basic_structure.convention.configureAndroidCompose
import com.android_project_basic_structure.convention.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

@Suppress("UNUSED")
class AndroidLibraryComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<LibraryExtension> {
                configureAndroidCompose(this)
                configureKotlinAndroid(this)
            }
        }
    }
}
