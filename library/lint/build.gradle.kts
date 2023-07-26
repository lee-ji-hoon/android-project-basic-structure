@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("android-project-basic-structure.android.library")
}

android {
    namespace = "com.android_project_basic_structure.library.lint"
}

dependencies {
    compileOnly(libs.bundles.lint)
}