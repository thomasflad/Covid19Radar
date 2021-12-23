/*
 * ***********************************************************************
 *
 * Copyright:       Robert Bosch GmbH, 2018 - 2021
 *
 * ************************************************************************
 */

// Use refreshVersions when possible:
// https://jmfayard.github.io/refreshVersions/

object Dependencies {

    object Gradle {
        const val android = "com.android.tools.build:gradle:_"
        const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:_"
        const val kmpNativeCoroutines = "com.rickclephas.kmp:kmp-nativecoroutines-gradle-plugin:_"
        const val ktlint = "org.jlleitschuh.gradle:ktlint-gradle:_"
    }

    const val kermit = "co.touchlab:kermit:_"
    const val ktorContentNegotiation = "io.ktor:ktor-client-content-negotiation:_"
    const val ktorKotlinxJson = "io.ktor:ktor-serialization-kotlinx-json:_"
}