plugins {
    id("structure.android.library")
    id("structure.android.library.compose")
    id("structure.android.hilt")
}

android {
    namespace = "com.structure.ui"
}

dependencies {

    implementation(libs.androidx.compose.activity)
    implementation(libs.material)
    implementation(libs.dagger.hilt.android)
    implementation(libs.androidx.compose.navigation)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.coil.compose)
    implementation(libs.lottie.compose)
}