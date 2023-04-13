plugins {
  id("com.android.application") version libs.versions.android.gradle.plugin apply false
  id("com.android.library") version libs.versions.android.gradle.plugin apply false
  id("org.jetbrains.kotlin.android") version libs.versions.kotlin.core apply false
  id("org.jetbrains.kotlin.plugin.serialization") version libs.versions.kotlin.core apply false
  id("com.google.dagger.hilt.android") version libs.versions.hilt apply false
  id("org.sonarqube") version libs.versions.sonarcloud
}

buildscript {
  dependencies {
    classpath(libs.oss.licenses.plugin)
  }
}

sonarqube {
  properties {
    property("sonar.projectKey", "okuzawats_android-clean-architecture")
    property("sonar.organization", "okuzawats")
    property("sonar.host.url", "https://sonarcloud.io")
  }
}
