plugins {
    id("structure.android.application")
    id("structure.android.application.compose")
    id("structure.android.hilt")
    // TODO ksp 적용
}

android {
    namespace = "com.structure"

    defaultConfig {
        applicationId = "com.structure"
        versionCode = 1
        versionName = "1.0"
    }
}

dependencies {
    lintChecks(project(":library:lint"))
    implementation(projects.library.test)

    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
    implementation(libs.timber)
}