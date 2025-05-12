plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")

    kotlin("plugin.serialization") version "1.6.10"
}

android {
    namespace = "com.mertyigit0.netwatcher"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.mertyigit0.netwatcher"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.appcompat)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation(libs.androidx.lifecycle.viewmodel.compose)


    implementation(libs.hilt.android)                   // ✅ GEREKLİ — Hilt core kütüphanesi
    ksp(libs.hilt.android.compiler)                     // ✅ GEREKLİ — Hilt annotation işlemleri için
    implementation(libs.androidx.hilt.work)             // 🔄 LAZIMSA — Eğer WorkManager içinde Hilt injection yapıyorsan
    implementation(libs.kotlinx.coroutines.android)     // ✅ GEREKLİ — Coroutines kullanıyorsan (ki kullanıyorsundur)
    implementation(libs.androidx.hilt.navigation.compose) // 🔄 LAZIMSA — Jetpack Compose + Navigation + Hilt kullanıyorsan
    implementation(libs.lifecycle.viewmodel.compose)    // 🔄 LAZIMSA — Compose'da ViewModel kullanıyorsan




    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)

    implementation(libs.androidx.navigation.compose)

    implementation(libs.androidx.work.runtime.ktx)
}
