// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.0-alpha08")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.30")
        classpath("com.diffplug.spotless:spotless-plugin-gradle:5.11.0")
    }
}

//apply(plugin = "com.diffplug.gradle.spotless")

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
