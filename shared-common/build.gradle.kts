allprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")

    group = "com.github.anddd7"
    version = "0.0.1-SNAPSHOT"
    java.sourceCompatibility = JavaVersion.VERSION_11

    repositories {
        mavenCentral()
        mavenLocal()
    }

    dependencies {
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
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
    `java-library`
    `maven-publish`

    kotlin("jvm") version "1.5.31"
}

dependencies {
    /** core */
    implementation(platform("org.springframework.boot:spring-boot-dependencies:2.5.6"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

java {
    withJavadocJar()
    withSourcesJar()
}

publishing {
    publications {
        register<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }
}
