import com.structure.convention.implementation
import com.structure.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("structure.android.library")
                apply("structure.android.hilt")
            }

            dependencies {
                implementation(project(":core:model"))
                implementation(project(":core:data"))
                implementation(project(":core:domain"))
                implementation(project(":design-system"))
                implementation(libs.findLibrary("coil.kt").get())
                implementation(libs.findLibrary("coil.kt.compose").get())
                implementation(libs.findLibrary("coil.kt.compose").get())
                implementation(libs.findLibrary("androidx.compose.activity").get())
                implementation(libs.findLibrary("androidx.compose.ui").get())
                implementation(libs.findLibrary("androidx.compose.material3").get())
                implementation(libs.findLibrary("androidx.compose.foundation").get())
                implementation(libs.findLibrary("androidx.compose.ui.tooling").get())
                implementation(libs.findLibrary("androidx.compose.ui.tooling.preview").get())
                implementation(libs.findLibrary("androidx.compose.lifecycle.runtime").get())
                implementation(libs.findLibrary("androidx.compose.lifecycle.viewmodel").get())
                implementation(libs.findLibrary("kotlin.coroutine.android").get())
                implementation(libs.findLibrary("kotlin.coroutine.core").get())
                // TODO 네비게이션 추가해야 함
            }
        }
    }
}