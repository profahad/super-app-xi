plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin") //  apply false
}

android {
    namespace = "com.fahad.project.common_domain"
    compileSdk = Platform.compileSdk

    defaultConfig {
        minSdk = Platform.minSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = Platform.sourceJavaVersion
        targetCompatibility = Platform.targetJavaVersion
    }
    kotlinOptions {
        jvmTarget = Platform.jvmTarget
    }
}

dependencies {
    applyCoreLibraryDesugaring()
    baseLifecycle()
    kotlinCoroutines()
    hilt()

    junit()
    kotlinCoroutinesTest()
}