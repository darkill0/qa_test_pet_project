plugins {
    id("java")
    id("io.qameta.allure") version "3.0.1"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    testImplementation("io.rest-assured:rest-assured:5.3.0")
    // Source: https://mvnrepository.com/artifact/io.rest-assured/json-schema-validator
    implementation("io.rest-assured:json-schema-validator:5.3.0")
// Source: https://mvnrepository.com/artifact/com.fasterxml.jackson.datatype/jackson-datatype-jsr310
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.21.3")
    testImplementation("com.fasterxml.jackson.core:jackson-databind:2.21.2")

    testImplementation("io.qameta.allure:allure-junit5:2.25.0")
    testImplementation("io.qameta.allure:allure-rest-assured:2.25.0")

    // Source: https://mvnrepository.com/artifact/io.qameta.allure/allure-selenide
    implementation("io.qameta.allure:allure-selenide:2.25.0")
    // Source: https://mvnrepository.com/artifact/com.codeborne/selenide
    implementation("com.codeborne:selenide:7.16.0")
    // Source: https://mvnrepository.com/artifact/org.junit-pioneer/junit-pioneer
    testImplementation("org.junit-pioneer:junit-pioneer:2.3.0")
}


tasks.test {
    useJUnitPlatform()
    maxParallelForks = Runtime.getRuntime().availableProcessors().coerceAtLeast(2)
    systemProperty(
        "allure.results.directory",
        System.getProperty(
            "allure.results.directory",
            "build/allure-results"
        )
    )

    val includeTag = System.getProperty("tag")

    if (!includeTag.isNullOrBlank()) {

        useJUnitPlatform {

            includeTags(
                *includeTag
                    .split(",")
                    .map { it.trim() }
                    .toTypedArray()
            )
        }

        println("Running tags: $includeTag")
    }
}