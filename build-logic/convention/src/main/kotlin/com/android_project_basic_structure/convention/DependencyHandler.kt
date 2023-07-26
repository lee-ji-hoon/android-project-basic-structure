package com.android_project_basic_structure.convention

import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.implementation(dependencyNotation: Any) {
    add("implementation", dependencyNotation)
}

fun DependencyHandler.kapt(dependencyNotation: Any) {
    add("kapt", dependencyNotation)
}