plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin") //  apply false
}

android {
    namespace = "com.fahad.project.x_i"
    compileSdk = Plateform.compileSdk

    defaultConfig {
        applicationId = "com.fahad.project.x_i"
        minSdk = Plateform.minSdk
        targetSdk = Plateform.targetSdk
        versionCode = Plateform.versionCode
        versionName = Plateform.versionName

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
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeCompiler
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    applyCoreLibraryDesugaring()
    baseLifecycle()
    compose()
    hilt()
    workManager()
    kotlinCoroutines()

    common()

    junit()
    kotlinCoroutinesTest()
}