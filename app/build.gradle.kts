plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.foxminded_mapsvslists_kotlin"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.foxminded_mapsvslists_kotlin"
        minSdk = 25
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.13.0-alpha02")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0-rc02")

    //Compose
    implementation(platform("androidx.compose:compose-bom:2023.10.01"))
    implementation("androidx.compose.ui:ui:1.6.0-beta03")
    implementation("androidx.compose.ui:ui-graphics:1.6.0-beta03")
    implementation("androidx.compose.ui:ui-tooling-preview:1.6.0-beta03")
    implementation("androidx.compose.material3:material3:1.2.0-beta01")//+
    implementation("androidx.activity:activity-compose:1.9.0-alpha01")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0-rc02")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.10.01"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.6.0-beta03")
    debugImplementation("androidx.compose.ui:ui-tooling:1.6.0-beta03")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.6.0-beta03")

    //Hilt
    implementation("com.google.dagger:hilt-android:2.50")
    implementation("androidx.fragment:fragment-ktx:1.7.0-alpha07")
    kapt("com.google.dagger:hilt-android-compiler:2.50")



    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.0-alpha02")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.0-alpha02")

}

kapt {
    correctErrorTypes = true
}