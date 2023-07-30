@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("structure.android.application")
    id("structure.android.hilt")
    // TODO ksp 적용
}

android {
    namespace = "com.structure"

    defaultConfig {
        applicationId = "com.structure"
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    lintChecks(project(":library:lint"))

    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
}