@file:Suppress("UnstableApiUsage")

include(":design-system:sample")


include(":feature:sample")


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
include(":core:model")
include(":core:data")
include(":core:domain")
include(":feature")
include(":design-system")
include(":library")
include(":library:lint")
