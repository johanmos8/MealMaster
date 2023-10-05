plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    //hilt
    kotlin("kapt")
}
android {
    namespace = "com.mirkwood.mealmaster"

    compileSdk = 34

    defaultConfig {
        minSdk = 24

    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}
dependencies {
    //modules
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(":domain"))
    //hilt
    implementation("com.google.dagger:hilt-android:2.44")
    kapt("com.google.dagger:hilt-android-compiler:2.44")
    //retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:4.11.0")
    //Client
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.1")
    //Moshi
    implementation("com.squareup.moshi:moshi:1.13.0")
    //OkHttp Interceptor
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.1")


}
// Allow references to generated code
kapt {
    correctErrorTypes = true
}
