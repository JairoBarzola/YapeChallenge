plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.jairbarzola.yapechallenge.domain"
    compileSdk = AppConfig.compileSDK
    defaultConfig {
        minSdk = AppConfig.minSDK
    }
}

dependencies {
    implementation(Dependencies.AndroidX.coreKtx)
    dependencyInjection()
    testing()

    implementation(project(":core:common"))
}