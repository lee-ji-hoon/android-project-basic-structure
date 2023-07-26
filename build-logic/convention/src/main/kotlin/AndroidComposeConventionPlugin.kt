import com.android.build.api.dsl.ApplicationExtension
import com.android_project_basic_structure.convention.ProjectConfigurations
import com.android_project_basic_structure.convention.configureAndroidCompose
import com.android_project_basic_structure.convention.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

@Suppress("UNUSED")
class AndroidComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<ApplicationExtension> {
                configureAndroidCompose(this)
                configureKotlinAndroid(this)
                defaultConfig {
                    targetSdk = ProjectConfigurations.targetSdk
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                }

                buildTypes {
                    release {
                        isMinifyEnabled = true
                        proguardFiles(
                            getDefaultProguardFile("proguard-android-optimize.txt"),
                            "proguard-rules.pro",
                        )
                    }
                }

                packaging {
                    resources.excludes.add("META-INF/LICENSE*")
                }
            }
        }
    }
}
