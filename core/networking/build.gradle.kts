plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.jairbarzola.yapechallenge.networking"
    compileSdk = AppConfig.compileSDK
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    networking()
}