plugins {
    id("android-project-basic-structure.android.library")
    id("android-project-basic-structure.android.hilt")
}

android {
    namespace = "com.android_project_basic_structure.data"
}

dependencies {
    implementation(projects.core.model)
    implementation(projects.core.domain)
}