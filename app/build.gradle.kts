@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("android-project-basic-structure.android.application")
    id("android-project-basic-structure.android.hilt")
    // TODO ksp 적용
}

android {
    namespace = "com.android_project_basic_structure"

    defaultConfig {
        applicationId = "com.android_project_basic_structure"
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    lintChecks(project(":library:lint"))
}