plugins {
	java
	id("org.springframework.boot") version "3.4.1"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.demo"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.security:spring-security-web")
	implementation("org.springframework.boot:spring-boot-starter-security:3.4.1")
	implementation("io.jsonwebtoken:jjwt-api:0.12.6")
	implementation("org.springframework:spring-webmvc:6.2.2")
	implementation("org.apache.tomcat:tomcat-jasper:10.1.34")
//	implementation("org.thymeleaf:thymeleaf:3.1.3.RELEASE")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")

	compileOnly("org.projectlombok:lombok:1.18.36")


	runtimeOnly("io.jsonwebtoken:jjwt-impl:0.12.6")
	runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.12.6")
	runtimeOnly("org.postgresql:postgresql")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
