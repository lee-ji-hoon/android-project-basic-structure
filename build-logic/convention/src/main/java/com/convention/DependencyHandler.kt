package com.convention

import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler

internal fun DependencyHandler.implementation(
    dependencyNotation: Any,
): Dependency? = add("implementation", dependencyNotation)