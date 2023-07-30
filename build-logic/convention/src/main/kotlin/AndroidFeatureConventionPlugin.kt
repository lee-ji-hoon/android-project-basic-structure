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
                implementation(libs.findLibrary("coil.kt.svg").get())
                implementation(libs.findBundle("compose").get())
                implementation(libs.findLibrary("kotlin.coroutine.android").get())
                implementation(libs.findLibrary("kotlin.coroutine.core").get())
                // TODO 네비게이션 추가해야 함
            }
        }
    }
}