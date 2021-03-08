@file:Suppress("SpellCheckingInspection")

plugins {
  id("com.android.application")
  id("kotlin-android")
  id("kotlin-kapt")
  id("kotlin-parcelize")
  id("com.google.android.gms.oss-licenses-plugin")
  id("org.ajoberstar.grgit") version "4.0.2"
//  id("com.google.gms.google-services")
//  id("com.google.firebase.crashlytics")
  id("dagger.hilt.android.plugin")
  id("androidx.navigation.safeargs.kotlin")
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

  implementation("androidx.core:core-ktx:${Versions.core}")
  implementation("androidx.appcompat:appcompat:${Versions.appcompat}")
  implementation("com.google.android.material:material:${Versions.material}")
  implementation("androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}")

  // activity
  implementation("androidx.activity:activity-ktx:${Versions.activity}")

  // fragment
  implementation("androidx.fragment:fragment-ktx:${Versions.fragment}")

  // navigation
  implementation("androidx.navigation:navigation-ui-ktx:${Versions.navigation}")
  implementation("androidx.navigation:navigation-fragment-ktx:${Versions.navigation}")
  implementation("androidx.legacy:legacy-support-v4:1.0.0")
  androidTestImplementation("androidx.navigation:navigation-testing:${Versions.navigation}")

  // dagger hilt
  implementation("com.google.dagger:hilt-android:${Versions.hilt_android}")
  kapt("com.google.dagger:hilt-android-compiler:${Versions.hilt_android}")
  implementation("androidx.hilt:hilt-common:${Versions.hilt}")
  implementation("androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hilt}")
  kapt("androidx.hilt:hilt-compiler:${Versions.hilt}")

  testImplementation("junit:junit:${Versions.junit}")
  androidTestImplementation("androidx.test.ext:junit:${Versions.atsl_junit}")
  androidTestImplementation("androidx.test.espresso:espresso-core:${Versions.atsl_espresso}")
}
