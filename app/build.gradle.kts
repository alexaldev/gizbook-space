plugins {
    alias(libs.plugins.gizbook.android.application)
    alias(libs.plugins.gizbook.android.compose)
}

android {
    namespace = "io.gizmolab.gizbookspace"

    defaultConfig {
        applicationId = "io.gizmolab.gizbookspace"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(projects.feature.home)
    implementation(projects.feature.catalogue)
    implementation(projects.feature.search)
    implementation(projects.feature.bookdetails)
    implementation(projects.feature.libraries)
    implementation(projects.feature.favorites)
    implementation(projects.feature.settings)

    implementation(projects.core.designsystem)
    implementation(projects.core.data)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.koin.android)
    implementation(libs.koin.androidx.compose)

    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
}
