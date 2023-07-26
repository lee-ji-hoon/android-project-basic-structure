
import com.android_project_basic_structure.convention.implementation
import com.android_project_basic_structure.convention.kapt
import com.android_project_basic_structure.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

@Suppress("UNUSED")
class AndroidHiltConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("kotlin-kapt")
                apply("dagger.hilt.android.plugin")
            }

            dependencies {
                implementation(libs.findLibrary("dagger-hilt-android").get())
                kapt(libs.findLibrary("dagger-hilt-android-compiler").get())
            }

            kapt {
                correctErrorTypes = true
            }
        }
    }
}
