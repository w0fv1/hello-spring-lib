plugins {
    id("java-library")
    id("io.spring.dependency-management") version "1.1.6"
    id("maven-publish")
    id("signing")
}

group = "dev.w0fv1"
version = "0.0.5"
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
    implementation("org.springframework.boot:spring-boot-autoconfigure:$springBootVersion")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor:$springBootVersion")
    testImplementation("org.springframework.boot:spring-boot-starter-test:$springBootVersion")
}

tasks.test {
    useJUnitPlatform()
}

//import org.gradle.plugins.signing.Sign

publishing {
            publications {
                create<MavenPublication>("mavenJava") {
                    from(components["java"])

                    pom {
                        name.set("Hello Spring Lib")
                        description.set("A Spring Boot starter that says hello.")
                        url.set("https://github.com/w0fv1/hello-spring-lib")

                        licenses {
                            license {
                                name.set("The Apache License, Version 2.0")
                                url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                            }
                        }
                        developers {
                            developer {
                                id.set("w0fv1")
                                name.set("w0fv1")
                                email.set("hi@w0fv1.dev")
                            }
                        }
                        scm {
                            connection.set("scm:git:git://github.com/w0fv1/hello-spring-lib.git")
                            developerConnection.set("scm:git:ssh://github.com/w0fv1/hello-spring-lib.git")
                            url.set("https://github.com/w0fv1/hello-spring-lib")
                        }
                    }
                }
            }
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/w0fv1/hello-spring-lib")
            credentials {
                username = "w0fv1" // 你的 GitHub 用户名
                password = System.getProperty("gpr.token") // 从系统属性中读取 Token
            }
        }
    }
        }

signing {
    // 如果在构建时手动输入密码，可以使用 `useGpgCmd()` 启用命令行 GPG
    useGpgCmd()
    sign(publishing.publications["mavenJava"])
}
