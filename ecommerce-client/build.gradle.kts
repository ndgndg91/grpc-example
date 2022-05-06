plugins {
    id("org.springframework.boot") version "2.6.7"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
}

group = "com.ndgndg91"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(project(":user-stub"))
    implementation(project(":product-stub"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    runtimeOnly("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:1.6.1")
    runtimeOnly("io.grpc:grpc-netty:1.46.0")
    runtimeOnly("org.jetbrains.kotlin:kotlin-reflect:1.6.21")
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