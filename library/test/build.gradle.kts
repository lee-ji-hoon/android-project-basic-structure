@file:Suppress("UnstableApiUsage")

plugins {
    id("structure.android.library")
    id("structure.android.library.compose")
    id("structure.android.hilt")
}

android {
    namespace = "com.structure.test"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    testOptions {
        unitTests.isIncludeAndroidResources = true
        unitTests.isReturnDefaultValues = true
    }
}

dependencies {

    api(libs.junit)
    api(libs.androidx.junit)
    api(libs.kotlin.coroutine.test)
    api(libs.dagger.hilt.android.compiler)
    api(libs.mockk)
    api(libs.turbine)
}