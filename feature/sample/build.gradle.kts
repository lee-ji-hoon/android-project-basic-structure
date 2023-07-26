plugins {
    id("android-project-basic-structure.android.library.compose")
    id("android-project-basic-structure.android.hilt")
}

android {
    namespace = "com.android_project_basic_structure.sample"
}

dependencies {
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.ui.tooling)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.lifecycle.runtime.compose)
    // TODO 네비게이션 추가해야 함
}