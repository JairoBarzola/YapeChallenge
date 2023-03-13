plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.jairbarzola.yapechallenge.core.common"
    compileSdk = AppConfig.compileSDK
    defaultConfig {
        minSdk = AppConfig.minSDK
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.9.0")
}