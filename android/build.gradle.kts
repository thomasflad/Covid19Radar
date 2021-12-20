plugins {
    id("com.android.application")
    kotlin("android")
}

android {

    compileSdk = 31

    defaultConfig {
        applicationId = "com.thomasflad.covid19radar.android"
        minSdk = 26
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        dataBinding = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(project(":common"))
    implementation(Google.android.material)
    implementation(AndroidX.appCompat)
    implementation(AndroidX.constraintLayout)
    implementation(AndroidX.activity.ktx)
    implementation(AndroidX.lifecycle.runtimeKtx)
    implementation(Koin.core)
    implementation(Koin.android)
    implementation(KotlinX.coroutines.core)
    implementation(KotlinX.coroutines.android)
}