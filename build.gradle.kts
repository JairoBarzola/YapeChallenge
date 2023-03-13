plugins {
    id("com.android.application") version Versions.androidApplication apply false
    id("com.android.library") version Versions.androidLibrary apply false
    id("org.jetbrains.kotlin.android") version Versions.kotlinAndroid apply false
    id("com.google.dagger.hilt.android") version Versions.hilt apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}