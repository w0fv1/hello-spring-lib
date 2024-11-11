plugins {
    id("java-library")
    id("io.spring.dependency-management") version "1.1.6"
}

group = "dev.w0fv1"
version = "1.0-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_21

val springBootVersion = "3.3.5" // 设置 Spring Boot 版本

repositories {
    mavenCentral()
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.boot:spring-boot-dependencies:$springBootVersion")
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-autoconfigure")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}
tasks.test {
    useJUnitPlatform()
}
