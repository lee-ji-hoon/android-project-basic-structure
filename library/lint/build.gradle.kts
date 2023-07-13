@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("kotlin")
}

dependencies {
    compileOnly("org.jetbrains.kotlin:kotlin-stdlib:1.8.22")
    compileOnly("com.android.tools.lint:lint-api:31.0.2")
    compileOnly("com.android.tools.lint:lint-checks:31.0.2")
}