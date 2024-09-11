plugins {
    kotlin("jvm") version "1.9.23"
}

group = "studio.hcmc"
version = "0.0.1-alpha"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}