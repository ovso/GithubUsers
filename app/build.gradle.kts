plugins {
//    id("com.diffplug.gradle.spotless") version "5.11.0"
  id("com.android.application")
  id("kotlin-android")
}

android {
  compileSdkVersion(DefaultConfig.compileSdk)

  defaultConfig {
    applicationId = DefaultConfig.appId
    minSdkVersion(DefaultConfig.minSdk)
    targetSdkVersion(DefaultConfig.targetSdk)
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      isDebuggable = false
      proguardFiles(getDefaultProguardFile(("proguard-android-optimize.txt")))
      proguardFile(file("proguard-rules.pro"))
      // library proguard settings
      val files = rootProject.file("proguard")
        .listFiles()
        ?.filter { it.name.startsWith("proguard") }
        ?.toTypedArray()

      proguardFiles(*files ?: arrayOf())
    }
    debug {
      isDebuggable = true
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
  kotlinOptions {
    jvmTarget = "1.8"
  }
}

dependencies {

  implementation("androidx.core:core-ktx:1.3.2")
  implementation("androidx.appcompat:appcompat:1.2.0")
  implementation("com.google.android.material:material:1.3.0")
  implementation("androidx.constraintlayout:constraintlayout:2.0.4")
  testImplementation("junit:junit:4.13.2")
  androidTestImplementation("androidx.test.ext:junit:1.1.2")
  androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
}
