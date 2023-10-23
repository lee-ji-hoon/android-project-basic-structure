plugins {
    id("structure.android.library")
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

    api(libs.dagger.hilt.android.compiler)
    api(libs.androidx.junit)
    api(libs.kotlin.coroutine.test)
    api(libs.mockk)
    api(libs.turbine)
    api(libs.kotest.runner)
    api(libs.kotest.assertions)
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}