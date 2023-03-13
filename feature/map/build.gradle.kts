plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-parcelize")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.jairbarzola.yapechallenge.map"
    compileSdk = AppConfig.compileSDK

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }
}

dependencies {
    androidx()
    utilities()
    dependencyInjection()
    testing()
    map()

    implementation(project(":core:common"))
    implementation(project(":core:designsystem"))
    implementation(project(":domain"))
}