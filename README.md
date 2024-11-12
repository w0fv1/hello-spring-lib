# Hello Spring Lib

`hello-spring-lib` 是一个用于演示如何创建和发布自定义 Spring Boot Starter 的库。该库的主要功能是展示如何在配置文件中设置参数，并在应用程序启动时自动加载配置和打印自定义消息。本项目的目的是帮助开发者学习如何制作一个简单的 Spring Boot Starter 并发布到 GitHub Packages 或 Maven Central。

## 功能

- **自动配置**：通过 Spring Boot 自动配置机制，将 `Hello Spring Lib` 自动注入到应用程序中。
- **可配置内容**：允许在配置文件中指定 `hellor.content` 属性，输出自定义消息。
- **GPG 签名**：包含 GPG 签名配置，用于发布到公共 Maven 仓库时验证包的完整性。

## 学习目标

通过此项目，你将学习到以下内容：

1. 如何构建一个 Spring Boot Starter，并为应用提供自动配置的功能。
2. 如何配置 `META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports` 文件，实现现代化的自动配置。
3. 如何使用 Gradle 的 `maven-publish` 插件和 `signing` 插件，将包发布到 GitHub Packages。
4. 如何为 Spring Boot Starter 添加依赖管理和发布配置。

## 使用方法

### 1. 添加依赖

在你的 Spring Boot 项目中，添加 `hello-spring-lib` 依赖。确保将 GitHub Packages 配置为 Maven 仓库。

**Gradle**

```kotlin
repositories {
    mavenCentral()
    maven {
        url = uri("https://maven.pkg.github.com/w0fv1/hello-spring-lib")
        credentials {
            username = "YOUR_GITHUB_USERNAME"
            password = "YOUR_GITHUB_TOKEN"
        }
    }
}

dependencies {
    implementation("dev.w0fv1:hello-spring-lib:0.0.5")
}
```

**Maven**

```xml
<repositories>
    <repository>
        <id>github</id>
        <url>https://maven.pkg.github.com/w0fv1/hello-spring-lib</url>
        <releases>
            <enabled>true</enabled>
        </releases>
    </repository>
</repositories>

<dependency>
    <groupId>dev.w0fv1</groupId>
    <artifactId>hello-spring-lib</artifactId>
    <version>0.0.5</version>
</dependency>
```

### 2. 配置属性

在你的 Spring Boot 项目的 `application.properties` 或 `application.yml` 文件中，添加以下配置项：

```properties
hellor.content=Spring Boot
```

### 3. 使用 `Hellor` Bean

在你的代码中，可以直接注入 `Hellor` Bean 并调用 `say()` 方法，查看输出。

```java
import dev.w0fv1.hello.spring.Hellor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringTestApplication implements CommandLineRunner {

    private final Hellor hellor;

    public HelloSpringTestApplication(Hellor hellor) {
        this.hellor = hellor;
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloSpringTestApplication.class, args);
    }

    @Override
    public void run(String... args) {
        hellor.say();
    }
}
```

### 输出

运行项目后，你应该会看到类似如下的输出：

```
Hello, Spring Boot!
```

## 目录结构

- `src/main/java`：包含 `Hellor` 类及其自动配置类 `HellorAutoConfiguration`。
- `src/main/resources/META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports`：用于声明自动配置类。

## 发布流程

1. 本项目使用 Gradle 配置了 `maven-publish` 插件和 `signing` 插件，可直接发布到 GitHub Packages。
2. 使用 `./gradlew publish -Dgpr.token=YOUR_GITHUB_TOKEN` 命令发布包到 GitHub Packages。

## 许可证

本项目使用 Apache License 2.0。详见 [LICENSE](http://www.apache.org/licenses/LICENSE-2.0.txt)。

---

这个 README 文件展示了如何使用 `hello-spring-lib` 项目，并帮助开发者了解如何构建和发布一个 Spring Boot Starter。