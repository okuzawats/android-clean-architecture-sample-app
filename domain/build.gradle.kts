plugins {
  id("com.android.library")
  id("org.jetbrains.kotlin.android")
  id("com.google.dagger.hilt.android")
  id("kotlin-kapt")
}

android {
  namespace = "com.okuzawats.cleanarchitecture.domain"
  compileSdk = libs.versions.android.compileSdk.get().toInt()

  defaultConfig {
    minSdk = libs.versions.android.minSdk.get().toInt()
    targetSdk = libs.versions.android.targetSdk.get().toInt()

    consumerProguardFiles("consumer-rules.pro")
  }

  buildTypes {
    getByName("release") {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }
  kotlinOptions {
    jvmTarget = JavaVersion.VERSION_11.toString()
  }
}

dependencies {
  testImplementation(project(":test"))
  implementation(libs.hilt.android)
  kapt(libs.hilt.compiler)
  testImplementation(libs.junit)
  testImplementation(libs.kotlin.coroutines.test)
  testImplementation(libs.mockk.android)
  testImplementation(libs.mockk.agent)
  testImplementation(libs.truth)
  testImplementation(libs.turbine)
}

kapt {
  // for dagger hilt
  correctErrorTypes = true
}
