plugins {
    id("android-project-basic-structure.android.library")
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.android_project_basic_structure.model"
}

dependencies {
    implementation(libs.kotlin.serialization.json)
}