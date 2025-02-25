plugins {
    id("java-library")
    kotlin("jvm") version "1.9.0"
    // Сериализация
    kotlin("plugin.serialization") version "1.9.0"
}


java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    // Сериализация
    implementation(libs.kotlinx.serialization.json)
}