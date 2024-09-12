plugins {
    kotlin("jvm")
}

group = "studio.hcmc"
version = "0.0.1-alpha"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":module"))

    implementation("org.jetbrains.kotlinx:kotlinx-datetime-jvm:0.5.0")
    implementation("org.jetbrains.exposed:exposed-core:0.54.0")
    implementation("org.jetbrains.exposed:exposed-dao:0.54.0")
    implementation("org.jetbrains.exposed:exposed-jdbc:0.54.0")
    implementation("org.jetbrains.exposed:exposed-kotlin-datetime:0.54.0")

}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}