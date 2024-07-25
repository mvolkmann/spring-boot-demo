plugins {
	id("org.springframework.boot") version "3.3.0"
	id("io.spring.dependency-management") version "1.1.5"
	id("java")
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
	mavenCentral()
}

dependencies {
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    implementation("org.apache.httpcomponents.client5:httpclient5:5.2.1")
    //implementation("org.opensearch.client:opensearch-java:2.8.1")
    // Starters are a set of convenient dependency descriptors that you can
    // include in your application. You get a one-stop shop for all the
    // Spring and related technologies that you need without having to
    // hunt through sample code and copy-paste loads of dependency descriptors. 
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("com.tngtech.archunit:archunit-junit5:1.3.0")
    testImplementation("org.assertj:assertj-core:3.26.3")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.boot:spring-boot-starter-webflux")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}