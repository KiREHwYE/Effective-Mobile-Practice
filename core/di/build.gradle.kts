plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)

    // KSP
    id("com.google.devtools.ksp") version "1.9.0-1.0.13"
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {

    // Dagger
    implementation(libs.dagger)
    ksp(libs.google.dagger.compiler)

    // Для Qualifiers (например, @IODispatcher)
    implementation(project(":core:util"))

    // KotlinX
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)
}