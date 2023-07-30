plugins {
    id("structure.android.feature")
}

android {
    namespace = "com.structure.sample"
}

dependencies {
    implementation(project(":library:test"))
}
