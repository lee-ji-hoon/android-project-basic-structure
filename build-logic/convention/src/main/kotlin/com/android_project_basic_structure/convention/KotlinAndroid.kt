package com.android_project_basic_structure.convention

import com.android.build.api.dsl.CommonExtension

internal fun configureKotlinAndroid(
    commonExtension: CommonExtension<*, *, *, *, *>,
) {
    commonExtension.apply {
        compileSdk = ProjectConfigurations.compileSdk

        defaultConfig {
            minSdk = ProjectConfigurations.minSdk

            vectorDrawables.useSupportLibrary = true
        }

        compileOptions {
            sourceCompatibility = ProjectConfigurations.javaVer
            targetCompatibility = ProjectConfigurations.javaVer
        }

        kotlinOptions {
            jvmTarget = ProjectConfigurations.javaVer.toString()
        }
    }
}