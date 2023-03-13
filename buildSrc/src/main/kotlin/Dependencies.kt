import org.gradle.api.artifacts.dsl.DependencyHandler

class Dependencies {


    object AndroidX {
        const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
        const val uiCompose = "androidx.compose.ui:ui:${Versions.compose}"
        const val runtimeLiveData = "androidx.compose.runtime:runtime-livedata:${Versions.compose}"
        const val material = "androidx.compose.material3:material3:${Versions.material}"

        const val toolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
        const val runtimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.runtimeKtx}"
        const val activityCompose = "androidx.activity:activity-compose:${Versions.activityCompose}"

        const val uiTooling =
            "androidx.compose.ui:ui-tooling:${Versions.compose}"
        const val navigationCompose =
            "androidx.navigation:navigation-compose:${Versions.navigationCompose}"

        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewModel}"
    }

    object Networking {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
        const val retrofitLoggingInterceptor =
            "com.squareup.okhttp3:logging-interceptor:${Versions.retrofitLoggingInterceptor}"
        const val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.converterGson}"
    }

    object DependencyInjection {
        const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
        const val kaptHilt = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
        const val navigationHilt = "androidx.hilt:hilt-navigation-compose:${Versions.navigationHilt}"
    }

    object Testing {
        const val truth = "com.google.truth:truth:${Versions.truth}"
        const val coroutinesTest =
            "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesTest}"
        const val coreTesting = "androidx.arch.core:core-testing:${Versions.coreTesting}"
        const val junit = "junit:junit:${Versions.junit}"
        const val extJunit = "androidx.test.ext:junit:${Versions.extJunit}"
        const val jUnitCompose = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"

        const val kotlinCoroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.kotlinCoroutinesTest}"
        const val mockitoCore = "org.mockito:mockito-core:${Versions.mockitoCore}"
        const val mockitoInline = "org.mockito:mockito-inline:${Versions.mockitoInline}"
        const val mockitoKotlin = "org.mockito.kotlin:mockito-kotlin:${Versions.mockitoKotlin}"
        const val mockserver = "com.squareup.okhttp3:mockwebserver:${Versions.mockserver}"
    }
    object Utilities {
        const val coilCompose = "io.coil-kt:coil-compose:${Versions.coilCompose}"
    }
    object Map {
        const val mapsCompose = "com.google.maps.android:maps-compose:${Versions.coilCompose}"
        const val mapsServices = "com.google.android.gms:play-services-maps:${Versions.mapsServices}"
    }

}

fun DependencyHandler.utilities(){
    implementation(Dependencies.Utilities.coilCompose)
}

fun DependencyHandler.map(){
    implementation(Dependencies.Map.mapsCompose)
    implementation(Dependencies.Map.mapsServices)
}

fun DependencyHandler.networking(){
    implementation(Dependencies.Networking.okHttp)
    implementation(Dependencies.Networking.converterGson)
    implementation(Dependencies.Networking.retrofit)
    implementation(Dependencies.Networking.retrofitLoggingInterceptor)
}

fun DependencyHandler.androidx() {
    implementation(Dependencies.AndroidX.coreKtx)
    implementation(Dependencies.AndroidX.uiCompose)
    implementation(Dependencies.AndroidX.runtimeLiveData)
    implementation(Dependencies.AndroidX.material)
    implementation(Dependencies.AndroidX.toolingPreview)
    implementation(Dependencies.AndroidX.runtimeKtx)
    implementation(Dependencies.AndroidX.activityCompose)
    debugImplementation(Dependencies.AndroidX.uiTooling)
    implementation(Dependencies.AndroidX.navigationCompose)
}

fun DependencyHandler.testing() {
    testImplementation(Dependencies.Testing.truth)
    testImplementation(Dependencies.Testing.coroutinesTest)
    testImplementation(Dependencies.Testing.coreTesting)
    testImplementation(Dependencies.Testing.junit)
    androidTestImplementation(Dependencies.Testing.extJunit)
    androidTestImplementation(Dependencies.Testing.jUnitCompose)
    testImplementation(Dependencies.Testing.kotlinCoroutinesTest)
    testImplementation(Dependencies.Testing.mockitoCore)
    testImplementation(Dependencies.Testing.mockitoInline)
    testImplementation(Dependencies.Testing.mockitoKotlin)
    testImplementation(Dependencies.Testing.mockserver)
}

fun DependencyHandler.dependencyInjection() {
    implementation(Dependencies.DependencyInjection.hilt)
    kapt(Dependencies.DependencyInjection.kaptHilt)
    implementation(Dependencies.DependencyInjection.navigationHilt)
}

private fun DependencyHandler.implementation(dependency: String) {
    add("implementation", dependency)
}

private fun DependencyHandler.androidTestImplementation(dependency: String) {
    add("androidTestImplementation", dependency)
}

private fun DependencyHandler.testImplementation(dependency: String) {
    add("testImplementation", dependency)
}

private fun DependencyHandler.debugImplementation(dependency: String) {
    add("debugImplementation", dependency)
}

private fun DependencyHandler.kapt(dependency: String) {
    add("kapt", dependency)
}