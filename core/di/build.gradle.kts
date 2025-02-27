plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)

    // KAPT
    kotlin("kapt")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {

    // Dagger
    implementation(libs.dagger)
    kapt(libs.google.dagger.compiler)

    // Для Qualifiers (например, @IODispatcher)
    implementation(project(":core:util"))

    // KotlinX
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)
}