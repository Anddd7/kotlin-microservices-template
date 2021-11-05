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
    id("org.openapi.generator") version "5.3.0"
}

dependencies {
    /** core */
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    implementation("org.springframework.cloud:spring-cloud-starter-openfeign:3.0.5")

    /** openapi */
    implementation("org.springdoc:springdoc-openapi-ui:1.5.12")
    implementation("org.springdoc:springdoc-openapi-kotlin:1.5.12")
    implementation("org.springdoc:springdoc-openapi-hateoas:1.5.12")
}

openApiGenerate {
    // gradle plugin - https://github.com/OpenAPITools/openapi-generator/blob/master/modules/openapi-generator-gradle-plugin/README.adoc

    val subProjectName = "backend-service"
    val subProjectPackage = "orders"

    generatorName.set("kotlin")
    inputSpec.set("$rootDir/../$subProjectName/specs/$subProjectName.json")
    outputDir.set("$rootDir")
    apiPackage.set("com.github.anddd7.client.$subProjectPackage")
    modelPackage.set("com.github.anddd7.client.$subProjectPackage.dto")
    templateDir.set("$rootDir/src/main/resources/templates/kotlin-feign")

    // kotlin config options - https://github.com/OpenAPITools/openapi-generator/blob/master/docs/generators/kotlin.md
    configOptions.put("serializationLibrary", "jackson")

    // only generate models and apis
    globalProperties.put("models", "")
    globalProperties.put("apis", "")
}
