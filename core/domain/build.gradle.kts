plugins {
    id("android-project-basic-structure.android.library")
}

android {
    namespace = "com.android_project_basic_structure.library.lint"
}

dependencies {
    implementation(projects.core.model)
    implementation(projects.core.data)
    implementation(libs.javax.inject)
}
