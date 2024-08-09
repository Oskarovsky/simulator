plugins {
    kotlin("jvm") version "1.9.0"
    kotlin("plugin.serialization") version "1.9.0"  // Dodaj to, aby włączyć serializację
    application
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

application {
    mainClass.set("com.slyko.simulator.MainKt")
}

kotlin {
    jvmToolchain(17)
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(kotlin("stdlib"))
    implementation("io.ktor:ktor-client-core:2.0.0")
    implementation("io.ktor:ktor-client-cio:2.0.0")
    implementation("io.ktor:ktor-client-json:2.0.0")
    implementation("io.ktor:ktor-client-logging:2.0.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("io.github.microutils:kotlin-logging:2.1.21")
    implementation("io.ktor:ktor-client-json:2.0.0")
    implementation("io.ktor:ktor-client-logging:2.0.0")
    implementation("io.github.microutils:kotlin-logging:2.1.21")

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

tasks {
    shadowJar {
        archiveFileName.set("simulator-all.jar")
    }
}