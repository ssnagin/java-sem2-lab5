plugins {
    application
    java
}

repositories {
    mavenCentral()
}

dependencies {
    

    testImplementation("org.junit.jupiter:junit-jupiter:5.10.1")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    mainClass = "com.ssnagin.lab5java.sem2.lab5.App"
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
