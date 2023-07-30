plugins {
    id("structure.android.library")
}

android {
    namespace = "com.structure.library.lint"
}

dependencies {
    implementation(projects.core.model)
    implementation(projects.core.data)
    implementation(libs.javax.inject)
    implementation(project(":library:test"))
}
