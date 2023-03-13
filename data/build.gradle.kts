plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.jairbarzola.yapechallenge.data"
    compileSdk = AppConfig.compileSDK
}

dependencies {

    androidx()
    networking()
    testing()
    dependencyInjection()

    implementation(project(":core:common"))
    implementation(project(":core:networking"))
    implementation(project(":domain"))
}