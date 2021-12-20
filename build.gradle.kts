 buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    @Suppress("GradlePluginVersion")
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:_")
        classpath("com.android.tools.build:gradle:_")
        classpath(Square.SqlDelight.gradlePlugin)
        classpath("com.rickclephas.kmp:kmp-nativecoroutines-gradle-plugin:_")
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