plugins {
    kotlin("jvm") version "1.9.0"
    kotlin("plugin.serialization") version "1.9.0"  // Dodaj to, aby włączyć serializację
    application
}

application {
    mainClass.set("main.MainKt")
}

dependencies {
    implementation("io.ktor:ktor-server-core:2.3.2")
    implementation("io.ktor:ktor-server-netty:2.3.2")
    implementation("io.ktor:ktor-client-core:2.3.2")
    implementation("io.ktor:ktor-client-cio:2.3.2")
    implementation("io.ktor:ktor-client-content-negotiation:2.3.2")
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.2") // Zależność dla JSON
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.2")
    implementation("ch.qos.logback:logback-classic:1.4.11")

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1") // Dodaj tę linię
}

repositories {
    mavenCentral() // Dodaj to, jeśli nie masz jeszcze tego bloku, aby móc pobrać zależności z Maven Central
}