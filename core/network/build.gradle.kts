plugins {
    id("java-library")
    kotlin("jvm") version "1.9.0"

    // Сериализация
    kotlin("plugin.serialization") version "1.9.0"

    // KAPT
    kotlin("kapt")
}


java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    // Сериализация
    implementation(libs.kotlinx.serialization.json)

    // Dagger
    implementation(libs.dagger)
    kapt(libs.google.dagger.compiler)

    //Ktor
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.android)
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.ktor.serialization.kotlinx.json)
    implementation(libs.ktor.client.okhttp)
    implementation(libs.ktor.client.logging)
}