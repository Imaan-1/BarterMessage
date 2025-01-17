plugins {
    alias(libs.plugins.android.application)


    // Add the Google services Gradle plugin

    id("com.google.gms.google-services")

}

android {
    namespace = "com.example.barteringapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.barteringapp"
        minSdk = 24
        targetSdk = 34
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
}

dependencies {



    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.play.services.maps)
    // Import the Firebase BoM

    implementation(platform("com.google.firebase:firebase-bom:33.1.2"))


    // TODO: Add the dependencies for Firebase products you want to use

    // When using the BoM, don't specify versions in Firebase dependencies

    implementation("com.google.firebase:firebase-analytics")
    implementation(libs.firebase.database)
    implementation (libs.firebase.database.v2005)
    implementation (libs.firebase.auth)

    // Add the dependencies for any other desired Firebase products

    // https://firebase.google.com/docs/android/setup#available-libraries

    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}