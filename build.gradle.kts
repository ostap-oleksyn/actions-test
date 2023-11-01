plugins {
    java
    id("io.qameta.allure") version "2.11.2"
}

group = "org.example"
version = "1.0-SNAPSHOT"
val allureVersion = "2.13.8"

tasks.withType(JavaCompile::class) {
    sourceCompatibility = "${JavaVersion.VERSION_11}"
    targetCompatibility = "${JavaVersion.VERSION_11}"
}

tasks {
    compileJava {
        options.encoding = "UTF-8"
    }
    compileTestJava {
        options.encoding = "UTF-8"
    }
}

repositories {
    mavenCentral()
}

allure {
    version.set(allureVersion)
}


dependencies {
    implementation(platform("org.junit:junit-bom:5.9.1"))
    implementation("org.junit.jupiter:junit-jupiter")
    implementation("io.qameta.allure:allure-java-commons:$allureVersion")
    implementation("com.codeborne:selenide:6.19.1")
    implementation("org.assertj:assertj-core:3.24.2")
}

tasks.test {
    useJUnitPlatform()

    testLogging {
        showStandardStreams = true
        showStackTraces = true
        showExceptions = true
        showCauses = true
        events("STARTED", "PASSED", "SKIPPED", "FAILED", "STANDARD_OUT")
    }
}