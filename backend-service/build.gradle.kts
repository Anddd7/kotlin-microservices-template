import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

allprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")

    group = "com.github.anddd7"
    version = "0.0.1-SNAPSHOT"
    java.sourceCompatibility = JavaVersion.VERSION_11

    repositories {
        mavenCentral()
    }

    dependencies {
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "11"
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

plugins {
    kotlin("jvm") version "1.5.31"

    /** spring */
    kotlin("plugin.spring") version "1.5.31"
    id("org.springframework.boot") version "2.5.6"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"

    /** openapi */
    id("com.github.johnrengelman.processes") version "0.5.0"
    id("org.springdoc.openapi-gradle-plugin") version "1.3.3"
}

dependencies {
    /** core */
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    /** openapi */
    implementation("org.springdoc:springdoc-openapi-ui:1.5.12")
    implementation("org.springdoc:springdoc-openapi-kotlin:1.5.12")
}

openApi {
    forkProperties.set("-Dspring.profiles.active=local")
    apiDocsUrl.set("http://localhost:9090/v3/api-docs")
    outputDir.set(file("$rootDir/specs"))
    outputFileName.set(rootProject.name + ".json")
}
