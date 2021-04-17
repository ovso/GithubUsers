@file:Suppress("SpellCheckingInspection")

plugins {
  id("com.android.application")
  id("kotlin-android")
  id("kotlin-kapt")
  id("kotlin-parcelize")
  id("com.google.android.gms.oss-licenses-plugin")
  id("org.ajoberstar.grgit") version "4.0.2"
  id("dagger.hilt.android.plugin")
  id("androidx.navigation.safeargs.kotlin")
}

//  id("com.google.gms.google-services")
//  id("com.google.firebase.crashlytics")


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
    getByName("debug") {
      isDebuggable = true
    }

    getByName("release") {
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
  }

  flavorDimensions("version")
  productFlavors {
    create("develop") {

    }
    create("staging") {

    }
    create("production") {

    }
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
  kotlinOptions {
    jvmTarget = "1.8"
  }

  buildFeatures {
    viewBinding = true
//    dataBinding = true
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

  // architecture
  implementation("com.airbnb.android:mavericks:${Versions.mavericks}")

  // coroutine
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine_android}")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine_core}")

  // startup
  implementation("androidx.startup:startup-runtime:${Versions.startup}")

  // dagger hilt
  implementation("com.google.dagger:hilt-android:${Versions.hilt_android}")
  kapt("com.google.dagger:hilt-android-compiler:${Versions.hilt_android}")
  implementation("androidx.hilt:hilt-common:${Versions.hilt}")
  implementation("androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hilt_viewmodel}")
  kapt("androidx.hilt:hilt-compiler:${Versions.hilt}")

//  implementation("com.google.dagger:hilt-android:2.33-beta")
//  kapt("com.google.dagger:hilt-compiler:2.33-beta")
  // For instrumentation tests
//  androidTestImplementation("com.google.dagger:hilt-android-testing:2.33-beta")
//  kaptAndroidTest("com.google.dagger:hilt-compiler:2.33-beta")
  // For local unit tests
//  testImplementation("com.google.dagger:hilt-android-testing:2.33-beta")
//  kaptTest("com.google.dagger:hilt-compiler:2.33-beta")

  // log
  implementation("com.orhanobut:logger:${Versions.logger}")
  implementation("com.jakewharton.timber:timber:${Versions.timber}")

  // network
  implementation("com.squareup.retrofit2:retrofit:${Versions.retrofit}")
  implementation("com.squareup.retrofit2:converter-gson:${Versions.retrofit}")
  implementation("com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}")
  implementation("com.squareup.retrofit2:converter-moshi:${Versions.retrofit}")
  implementation("com.squareup.okhttp3:logging-interceptor:${Versions.logging_interceptor}")
  implementation("com.github.akarnokd:rxjava3-retrofit-adapter:${Versions.retrofit_rxjava3}")

  // rx
  implementation("io.reactivex.rxjava3:rxjava:${Versions.rxjava3}")
  implementation("io.reactivex.rxjava3:rxandroid:${Versions.rxjava3_rxandroid}")
  implementation("io.reactivex.rxjava3:rxkotlin:${Versions.rxjava3_rxkotlin}")

  // datastore
  implementation("androidx.datastore:datastore-preferences:${Versions.datastore}")
  implementation("androidx.datastore:datastore-preferences-rxjava3:${Versions.datastore}")
  implementation("androidx.datastore:datastore-preferences-core:${Versions.datastore}")

  // lifecycle
  implementation("androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}")
  implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}")
  implementation("androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}")
  implementation("androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle}")
  implementation("androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}")

  // moshi
  implementation("com.squareup.moshi:moshi-kotlin:${Versions.moshi}")
  kapt("com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}")

  // architecture
  implementation("com.airbnb.android:mavericks:${Versions.mvrx}")

  // image loader
  implementation("io.coil-kt:coil:1.1.1")

  implementation("androidx.paging:paging-runtime-ktx:${Versions.paging}")

  testImplementation("junit:junit:${Versions.junit}")
  androidTestImplementation("androidx.test.ext:junit:${Versions.atsl_junit}")
  androidTestImplementation("androidx.test.espresso:espresso-core:${Versions.atsl_espresso}")
}

kapt {
  correctErrorTypes = true
}
