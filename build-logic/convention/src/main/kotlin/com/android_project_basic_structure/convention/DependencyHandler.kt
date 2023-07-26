package com.android_project_basic_structure.convention

import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.provider.Provider
import java.util.Optional

internal fun DependencyHandler.implementation(
    dependencyNotation: Any,
): Dependency? = add("implementation", dependencyNotation)

internal fun <T> DependencyHandler.kapt(
    dependencyNotation: Optional<Provider<T>>,
): Dependency? = add("kapt", dependencyNotation.get())