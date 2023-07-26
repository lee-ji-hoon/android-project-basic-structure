package com.android_project_basic_structure.convention

import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler

internal fun DependencyHandler.implementation(
    dependencyNotation: Any,
): Dependency? = add("implementation", dependencyNotation)