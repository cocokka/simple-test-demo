# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/3.4.4/gradle-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.4.4/gradle-plugin/packaging-oci-image.html)
* [Spring Boot Testcontainers support](https://docs.spring.io/spring-boot/3.4.4/reference/testing/testcontainers.html#testing.testcontainers)
* [MyBatis Framework](https://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/)
* [Testcontainers](https://java.testcontainers.org/)

### Guides

The following guides illustrate how to use some features concretely:

* [MyBatis Quick Start](https://github.com/mybatis/spring-boot-starter/wiki/Quick-Start)

### Additional Links

These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

### Testcontainers support

This project
uses [Testcontainers at development time](https://docs.spring.io/spring-boot/3.4.4/reference/features/dev-services.html#features.dev-services.testcontainers).

Testcontainers has been configured to use the following Docker images:

Please review the tags of the used images and set them to the same as you're running in production.

### Features

#### Testing

* Unit tests: use Mockito to mock MyBatis Mapper.
* Integration tests: start Spring context, test Controller + MyBatis + H2, tagged with @Tag("integration").
* Regression tests: cover full CRUD flow, tagged with @Tag("regression").

#### H2 DB

Automatically load schema.sql 和 test-data.sql in test environment.
* http://localhost:8080/h2-console
* jdbc url: jdbc:h2:mem:testdb
* username: sa
* password:

#### Gradle

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)]
* [Testcontainers at development time](https://docs.spring.io/spring-boot/3.4.4/reference/features/dev-services.html#features.dev-services.testcontainers)
* Jacoco