plugins {
    id("structure.android.library")
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.structure.model"
}

dependencies {
    implementation(libs.kotlin.serialization.json)
}