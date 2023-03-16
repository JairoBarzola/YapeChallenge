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
    implementation(Dependencies.AndroidX.coreKtx)
}