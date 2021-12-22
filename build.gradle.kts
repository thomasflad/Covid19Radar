 buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    @Suppress("GradlePluginVersion")
    dependencies {
        classpath(Dependencies.Gradle.kotlin)
        classpath(Dependencies.Gradle.android)
        classpath(Dependencies.Gradle.ktlint)
        classpath(Dependencies.Gradle.kmpNativeCoroutines)
        classpath(Square.SqlDelight.gradlePlugin)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}