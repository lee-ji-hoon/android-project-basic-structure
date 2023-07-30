@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("structure.android.library")
}

android {
    namespace = "com.structure.library.lint"
}

dependencies {
    compileOnly(libs.bundles.lint)
}