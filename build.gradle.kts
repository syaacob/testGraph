plugins {
    id("java")
    id("application")
    id("io.freefair.lombok") version "8.6"
}

group = "com.saiful"
version = "1.0-SNAPSHOT"

java{
    toolchain{
        languageVersion = JavaLanguageVersion.of(21)
    }

}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.fasterxml.jackson.core:jackson-core:2.16.2")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.16.2")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
application {
    mainClass = "com.saiful.Main"
}