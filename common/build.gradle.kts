plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.android.library")
    id("com.squareup.sqldelight")
    id("com.rickclephas.kmp.nativecoroutines")
}

kotlin {
    android()
    
    listOf(iosX64(), iosArm64()).forEach {
        it.binaries.framework {
            baseName = "common"
        }
    }

    @Suppress("UNUSED_VARIABLE")
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Kotlin.stdlib)
                implementation(Koin.core)
                implementation(KotlinX.Coroutines.core)
                implementation(Square.SqlDelight.coroutinesExtensions)
                implementation(Ktor.client.core)
                implementation(Ktor.client.json)
                implementation(Ktor.client.serialization)
                implementation(Ktor.client.logging)
                implementation(Touchlab.stately.common)
                implementation(Touchlab.stately.concurrency)
                implementation(Dependencies.kermit)
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(Kotlin.test.common)
                implementation(Kotlin.test.annotationsCommon)
                implementation(Koin.test)
                implementation(KotlinX.Coroutines.test)
                implementation(CashApp.turbine)
                implementation(Ktor.client.mock)
            }
        }

        val androidMain by getting {
            dependencies {
                implementation(Square.SqlDelight.drivers.android)
                implementation(Ktor.client.okHttp)
            }
        }

        val androidTest by getting

        val iosX64Main by getting

        val iosArm64Main by getting

        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            dependencies {
                implementation(Square.SqlDelight.drivers.native)
                implementation(Ktor.client.darwin)
            }
        }

        val iosX64Test by getting

        val iosArm64Test by getting

        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
        }

        all {
            languageSettings.optIn("kotlinx.coroutines.ExperimentalCoroutinesApi")
        }
    }
}

android {
    compileSdk = 31
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 26
        targetSdk = 31
    }
}

sqldelight {
    database("Covid19RadarDatabase") {
        packageName = "com.thomasflad.covid19radar"
    }
}