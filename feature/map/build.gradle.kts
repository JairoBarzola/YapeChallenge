plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-parcelize")
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
    testing()
    map()

    implementation(project(":core:common"))
    implementation(project(":core:designsystem"))
    implementation(project(":domain"))
}