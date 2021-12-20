pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

plugins {
    id("de.fayard.refreshVersions") version "0.30.0"
////                            # available:"0.30.1"
}

rootProject.name = "Covid19Radar"
include(":android")
include(":common")