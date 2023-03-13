plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}
android {
    namespace = "com.jairbarzola.yapechallenge.designsystem"
    compileSdk = AppConfig.compileSDK

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation(Dependencies.AndroidX.uiCompose)

    implementation(Dependencies.AndroidX.activityCompose)
    debugImplementation(Dependencies.AndroidX.uiTooling)

    implementation(Dependencies.AndroidX.material)
    implementation(Dependencies.AndroidX.toolingPreview)

}