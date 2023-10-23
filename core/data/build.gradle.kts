plugins {
    id("structure.android.library")
    id("structure.android.hilt")
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.structure.data"
}

dependencies {
    implementation(projects.core.model)
    implementation(projects.core.domain)
    implementation(projects.library.test)

    implementation(libs.kotlin.serialization.json)
    implementation(libs.kotlin.serialization.converter)
    implementation(libs.retrofit)
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging)
}