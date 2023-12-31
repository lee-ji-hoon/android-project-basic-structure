@file:Suppress("UnstableApiUsage")

include(":core:ui")


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

rootProject.name = "structure"
include(":app")
include(":core")
include(":core:model")
include(":core:data")
include(":feature:sample")
include(":core:domain")
include(":feature")
include(":library")
include(":library:lint")
include(":library:test")
