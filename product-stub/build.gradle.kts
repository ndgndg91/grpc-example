import com.google.protobuf.gradle.*

plugins {
    id("com.google.protobuf") version "0.8.18"
    kotlin("jvm") version "1.6.21"
    // Generate IntelliJ IDEA's .idea & .iml project files
    // Starting with 0.8.4 of protobuf-gradle-plugin, *.proto and the gen output files are added
    // to IntelliJ as sources. It is no longer necessary to add them manually to the idea {} block
    // to jump to definitions from Java and Kotlin files.
    // For best results, install the Protobuf and Kotlin plugins for IntelliJ.
    id("idea")

}

val grpcVersion = "1.46.0"
val protobufVersion = "3.14.0"
val grpcKotlinVersion = "1.2.1"

group = "com.ndgndg91"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation("io.grpc:grpc-kotlin-stub:${grpcKotlinVersion}")
    implementation("io.grpc:grpc-stub:${grpcVersion}")
    implementation("io.grpc:grpc-protobuf:${grpcVersion}")
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:${protobufVersion}"
    }

    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:${grpcVersion}"
        }
        id("grpckt") {
            artifact = "io.grpc:protoc-gen-grpc-kotlin:${grpcKotlinVersion}:jdk7@jar"
        }
    }

    generateProtoTasks {
        all().forEach {

            it.plugins {
                id("grpc")
                id("grpckt")
            }
        }
    }
}