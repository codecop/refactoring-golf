plugins {
    base
    kotlin("jvm") version "1.3.70" apply false
}

allprojects {
    group = "uk.co.autotrader"
    version = "1.0"
}

subprojects {
    apply {
        plugin("org.jetbrains.kotlin.jvm")
    }

    repositories {
        mavenCentral()
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }

    tasks.named<Test>("test") {
        useJUnitPlatform()
        testLogging {
            events("passed", "skipped", "failed")
        }
    }

    dependencies {
        "implementation"(kotlin("stdlib-jdk8"))
        "implementation"(kotlin("reflect"))
        "testImplementation"("org.junit.jupiter:junit-jupiter:5.6.2")
    }
}
