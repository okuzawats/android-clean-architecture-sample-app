@file:Suppress("UnstableApiUsage")

pluginManagement {
  repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
  }
}
enableFeaturePreview("VERSION_CATALOGS")
dependencyResolutionManagement {
  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  repositories {
    google()
    mavenCentral()
  }
}
rootProject.name = "CleanArchitecture"
include(":app")
include(":feature:dog")
include(":domain")
include(":data")
include(":datasource")
include(":test")
