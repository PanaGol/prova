plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.myapplication"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.myapplication"
        minSdk = 26
        //noinspection ExpiredTargetSdkVersion
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
    buildFeatures{

        viewBinding = true

    }




    compileOptions {

        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8


    }
    packagingOptions {
        // Escludi i file con nomi duplicati
        exclude("META-INF/DEPENDENCIES")
        exclude ("META-INF/NOTICE")
        exclude ("META-INF/LICENSE")
        exclude ("META-INF/license.txt")
        exclude ("META-INF/notice.txt")
        exclude ("META-INF/INDEX.LIST")
        exclude ("META-INF/AL2.0")
        exclude  ("META-INF/LGPL2.1")
        exclude  ("META-INF/io.netty.versions.properties")

        // Aggiungi qui altre configurazioni di packagingOptions, se necessario
    }

}

dependencies {
    implementation ("com.github.barteksc:android-pdf-viewer:3.2.0-beta.1")
    implementation ("androidx.appcompat:appcompat:1.6.1")
    implementation ("com.google.android.material:material:1.12.0")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation ("junit:junit:4.13.2")
    implementation ("androidx.recyclerview:recyclerview:1.3.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")
    implementation("com.microsoft.identity.client:msal:5.3.0"){ exclude (group="com.microsoft.device.display")}
    implementation("com.microsoft.graph:microsoft-graph:6.9.0")
    implementation ("com.squareup.okhttp3:okhttp:4.12.0") // Verifica sempre la versione più recente
    //MSAL
    implementation ("com.azure:azure-identity:1.12.1")


}
