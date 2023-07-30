plugins {
    id("structure.android.library")
}

android {
    namespace = "com.structure.library.lint"
}

dependencies {
    compileOnly(libs.bundles.lint)
}