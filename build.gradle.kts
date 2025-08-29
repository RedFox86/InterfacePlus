plugins {
    id("java")
    id("com.diffplug.spotless") version "7.0.3"
}

group = "net.redfox.interfaceplus"
version = "1.0.2"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

spotless {
    java {
        removeUnusedImports()
        googleJavaFormat().reflowLongStrings(false).aosp()
        formatAnnotations()
    }
}