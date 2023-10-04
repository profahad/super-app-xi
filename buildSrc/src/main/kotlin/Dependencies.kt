import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

object Dependencies {

    // Core
    const val coreKtx = "androidx.core:core-ktx:${Versions.corektx}"
    const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleKtx}"
    const val lifecycleViewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleKtx}"
    const val lifecycleViewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifecycleKtx}"
    const val lifecycleLiveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleKtx}"
    const val lifecycleRuntimeCompose = "androidx.lifecycle:lifecycle-runtime-compose:${Versions.lifecycleKtx}"
    const val lifecycleViewModelSavedState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.lifecycleKtx}"
    const val lifecycleService = "androidx.lifecycle:lifecycle-service:${Versions.lifecycleKtx}"
    const val lifecycleProcess = "androidx.lifecycle:lifecycle-process:${Versions.lifecycleKtx}"
    const val lifecycleReactiveStreamKtx= "androidx.lifecycle:lifecycle-reactivestreams-ktx:${Versions.lifecycleKtx}"

    const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycleKtx}"
    const val arcCoreTesting= "androidx.arch.core:core-testing:${Versions.lifecycleArc}"
    const val lifecycleRuntimeTesting= "androidx.lifecycle:lifecycle-runtime-testing:${Versions.lifecycleKtx}"

    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val material = "com.google.android.material:material:${Versions.material}"


    // Compose
    const val activityCompose = "androidx.activity:activity-compose:${Versions.activityCompose}"
    const val composeBom = "androidx.compose:compose-bom:${Versions.composeBom}"
    const val composeUi = "androidx.compose.ui:ui"
    const val composeUiGraphics = "androidx.compose.ui:ui-graphics"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling"
    const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview"
    const val composeUiTestManifest = "androidx.compose.ui:ui-test-manifest"
    const val composeJUnit4 = "androidx.compose.ui:ui-test-junit4"
    const val composeMaterial3 = "androidx.compose.material3:material3"


    // Junit
    const val junit = "junit:junit:${Versions.junit}"
    const val junitExt = "androidx.test.ext:junit:${Versions.junitExt}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"


    // Hilt
    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val hiltAgp = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"


    // OkHttp
    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val okHttpLoggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"


    // Retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val moshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"


    // Room
    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"

    // Kotlin Coroutines
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    const val coroutinesPlayServices = "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:${Versions.coroutines}"

    //Ktor
    const val ktorClientCore = "io.ktor:ktor-client-core:${Versions.ktor}"
    const val ktorClientContentNegotiation = "io.ktor:ktor-client-content-negotiation:${Versions.ktor}"
    const val ktorClientSerializationKotlinx = "io.ktor:ktor-serialization-kotlinx-json:${Versions.ktor}"
    const val ktorClientJson = "io.ktor:ktor-client-json:${Versions.ktor}"
    const val ktorClientLogging = "io.ktor:ktor-client-logging:${Versions.ktor}"
    const val ktorClientSerialization = "io.ktor:ktor-client-serialization:${Versions.ktor}"
    const val ktorClientAndroid = "io.ktor:ktor-client-android:${Versions.ktor}"
    const val ktorAuth = "io.ktor:ktor-client-auth:${Versions.ktor}"

    // Plugins
    const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val kotlinSerializationCore = "org.jetbrains.kotlinx:kotlinx-serialization-core:${Versions.kotlinSerialization}"
    const val kotlinSerialization = "org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlin}"
}

fun DependencyHandler.room() {
    implementation(Dependencies.roomRuntime)
    implementation(Dependencies.roomKtx)
    kapt(Dependencies.roomCompiler)
}

fun DependencyHandler.retrofit() {
    implementation(Dependencies.retrofit)
    implementation(Dependencies.moshiConverter)
    implementation(Dependencies.okHttp)
    implementation(Dependencies.okHttpLoggingInterceptor)
}

fun DependencyHandler.baseLifecycle() {
    implementation(Dependencies.coreKtx)
    implementation(Dependencies.lifecycleRuntimeKtx)
    implementation(Dependencies.lifecycleViewModelKtx)
    implementation(Dependencies.lifecycleLiveDataKtx)
    implementation(Dependencies.lifecycleViewModelSavedState)
    implementation(Dependencies.lifecycleViewModelCompose)
    implementation(Dependencies.lifecycleRuntimeCompose)

    kapt(Dependencies.lifecycleCompiler)
    testImplementation(Dependencies.arcCoreTesting)
    testImplementation(Dependencies.lifecycleRuntimeTesting)
}

fun DependencyHandler.compose() {
    implementation(Dependencies.activityCompose)
    implementation(platform(Dependencies.composeBom))
    implementation(Dependencies.composeUi)
    implementation(Dependencies.composeUiGraphics)
    implementation(Dependencies.composeMaterial3)

    androidTestImplementation(platform(Dependencies.composeBom))
    androidTestImplementation(Dependencies.composeJUnit4)
    debugImplementation(Dependencies.composeUiToolingPreview)
    debugImplementation(Dependencies.composeUiTestManifest)
}

fun DependencyHandler.junit() {
    testImplementation(Dependencies.junit)
    androidTestImplementation(Dependencies.junitExt)
    androidTestImplementation(Dependencies.espressoCore)
}

fun DependencyHandler.hilt() {
    implementation(Dependencies.hiltAndroid)
    kapt(Dependencies.hiltCompiler)
}

fun DependencyHandler.coreMaterial() {
    implementation(Dependencies.appCompat)
    implementation(platform(Dependencies.material))
}

fun DependencyHandler.kotlinCoroutines() {
    implementation(Dependencies.coroutinesCore)
    implementation(Dependencies.coroutinesAndroid)
}

fun DependencyHandler.kotlinCoroutinesTest() {
    testImplementation(Dependencies.coroutinesTest)
}


fun DependencyHandler.ktor() {
    implementation(Dependencies.ktorClientCore)
    implementation(Dependencies.ktorClientContentNegotiation)
    implementation(Dependencies.ktorClientSerializationKotlinx)
    implementation(Dependencies.ktorAuth)
    implementation(Dependencies.ktorClientJson)
    implementation(Dependencies.ktorClientLogging)
    implementation(Dependencies.ktorClientSerialization)
}


fun DependencyHandler.common() {
    implementation(project(":common"))
}

fun DependencyHandler.apiCommonData() {
    api(project(":common-data"))
}

fun DependencyHandler.commonData() {
    implementation(project(":common-data"))
}

fun DependencyHandler.apiCommonDomain() {
    api(project(":common-domain"))
}
fun DependencyHandler.commonDomain() {
    implementation(project(":common-domain"))
}