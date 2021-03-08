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
    classpath("com.android.tools.build:gradle:${Versions.gradle}")
    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}")
    classpath("com.google.android.gms:oss-licenses-plugin:${Versions.licensesPlugin}")
    classpath("com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt_plugin}")
    classpath("androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}")
//    classpath("com.google.firebase:firebase-crashlytics-gradle:2.5.1")
//    classpath("com.google.gms:google-services:${Versions.googleService}")
  }
}

tasks.register("clean", Delete::class) {
  delete(rootProject.buildDir)
}
