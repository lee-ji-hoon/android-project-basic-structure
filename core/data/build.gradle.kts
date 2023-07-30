plugins {
    id("structure.android.library")
    id("structure.android.hilt")
}

android {
    namespace = "com.structure.data"
}

dependencies {
    implementation(projects.core.model)
    implementation(projects.core.domain)
}