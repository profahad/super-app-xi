plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin") //  apply false
}

android {
    namespace = "com.fahad.project.x_i"
    compileSdk = Platform.compileSdk

    defaultConfig {
        applicationId = "com.fahad.project.x_i"
        minSdk = Platform.minSdk
        targetSdk = Platform.targetSdk
        versionCode = Platform.versionCode
        versionName = Platform.versionName

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
        sourceCompatibility = Platform.sourceJavaVersion
        targetCompatibility = Platform.targetJavaVersion
    }
    kotlinOptions {
        jvmTarget = Platform.jvmTarget
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