@file:Suppress("UnstableApiUsage")

include(":core:domain")


pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "android-project-basic-structure"
include(":app")
include(":core")
include(":feature")
include(":design-system")
include(":library")
include(":library:lint")
