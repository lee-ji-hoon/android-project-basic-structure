plugins {
    id("structure.android.library")
    id("structure.android.library.compose")
    id("structure.android.hilt")
}

android {
    namespace = "com.structure.sample"
}

dependencies {
    testImplementation(projects.library.test)

    implementation(projects.core.domain)
    implementation(projects.core.ui)

    implementation(libs.androidx.compose.activity)
    implementation(libs.material)
    implementation(libs.dagger.hilt.android)
    implementation(libs.androidx.compose.navigation)
    implementation(libs.androidx.hilt.navigation.compose)
}
